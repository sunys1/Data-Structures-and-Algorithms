package ibm;

/***
 * 636. https://leetcode.com/problems/exclusive-time-of-functions/description/?envType=company&envId=ibm&favoriteSlug=ibm-all
 *
 * My first-try solution
 */
public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] exclusiveTime = new int[n];
        Stack<Integer> callStack = new Stack<>();

        int funcId = 0, topFuncId = 0, currentTime = 0, prevTime = 0;
        String[] log_parts;
        String label = "", prevStatus = "", currStatus = "";

        for(String s : logs){
            log_parts = s.split(":");
            funcId = Integer.parseInt(log_parts[0]);
            label = log_parts[1];
            currStatus = label;
            currentTime = Integer.parseInt(log_parts[2]);

            if(label.equals("start")){
                if(callStack.isEmpty()){
                    callStack.push(funcId);
                }else{
                    topFuncId = callStack.peek();
                    // calculate exclusive time for previous function call
                    if(prevStatus.equals("start")){
                        exclusiveTime[topFuncId] += currentTime - prevTime;
                    }else{ // prevStatus = "end"
                        if(currentTime - prevTime > 1){
                            exclusiveTime[topFuncId] += currentTime - prevTime - 1;
                        }
                    }
                    // push new function into the stack
                    callStack.push(funcId);
                }
            }else{ // label = 'end'
                topFuncId = callStack.peek(); // stack can't be empty at this point
                if(prevStatus.equals("start")){ //same function continous start-end
                    exclusiveTime[topFuncId] += currentTime - prevTime + 1;
                }else{ // same function discontinued start-end
                    exclusiveTime[topFuncId] += currentTime - prevTime;
                }
                callStack.pop();
            }
            prevTime = currentTime;
            prevStatus = currStatus;
        }

        return exclusiveTime;
    }
}

/***
 * Sample top solution:
 *
 */

class Solution {

    class Log {
        private boolean isStart;
        private int index;
        private int timestamp;
        private int sumTime;
        private int pos;

        public Log(boolean isStart, int index, int timestamp, int sumTime, int pos) {
            this.isStart = isStart;
            this.index = index;
            this.timestamp = timestamp;
            this.sumTime = sumTime;
            this.pos = pos;
        }

        public String toString() {
            return "isStart: " + isStart + " index: " + index + " timestamp " + timestamp + " " + sumTime;
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];

        int pos = 0;
        while (pos < logs.size()) {
            Log log = exclusiveTime(pos, logs, res);
            pos = log.pos + 1;
        }

        return res;
    }

    private Log exclusiveTime(int pos, List<String> logs, int[] res) {
        String log = logs.get(pos);
        int index = getIndex(log);
        boolean isStart = isStart(log);
        int timestamp = getTimestamp(log);

        if (isStart) {
            int sumTime = 0;
            Log nextLog = null;
            int nextPos = pos + 1;

            while (true) {
                nextLog = exclusiveTime(nextPos, logs, res);
                nextPos = nextLog.pos;
                if ((nextLog.index == index) && (!nextLog.isStart)) {
                    break;
                }
                sumTime += nextLog.sumTime;
                nextPos++;
            }

            int time = nextLog.timestamp + 1 - timestamp - sumTime;
            res[index] += time;

            return new Log(true, index, timestamp, sumTime + time, nextPos);
        } else {
            return new Log(false, index, timestamp, 0, pos);
        }
    }

    private int getIndex(String log) {
        int colonIndex = log.indexOf(':');
        String indexString = log.substring(0, colonIndex);
        return Integer.parseInt(indexString);
    }

    private boolean isStart(String log) {
        int colonIndex = log.indexOf(':');
        return log.charAt(colonIndex + 1) == 's';
    }

    private int getTimestamp(String log) {
        int colonIndex = log.lastIndexOf(":");
        String timestampString = log.substring(colonIndex + 1, log.length());
        return Integer.parseInt(timestampString);
    }
}

/***
 * Grok3 Solution:
 */

import java.util.*;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> stack = new Stack<>();  // Stack to track active functions [function_id, start_time]
        int[] result = new int[n];  // Array to store exclusive time for each function
        int prevTime = 0;  // Track the previous timestamp

        for (String log : logs) {
            // Parse the log: function_id:operation:timestamp
            String[] parts = log.split(":");
            int functionId = Integer.parseInt(parts[0]);
            String operation = parts[1];
            int timestamp = Integer.parseInt(parts[2]);

            if (operation.equals("start")) {
                // If there's a function already running, update its time
                if (!stack.isEmpty()) {
                    int[] prevFunction = stack.peek();
                    result[prevFunction[0]] += timestamp - prevTime;
                }
                stack.push(new int[]{functionId, timestamp});
                prevTime = timestamp;
            } else {  // operation.equals("end")
                // Pop the function that just ended
                int[] currentFunction = stack.pop();
                int functionIdEnded = currentFunction[0];
                int startTime = currentFunction[1];
                // Add the time spent in this function (exclusive), inclusive of start and end timestamps
                result[functionIdEnded] += timestamp - startTime + 1;
                // Update prevTime for the next function (if any)
                prevTime = timestamp + 1;
            }
        }

        return result;
    }
}