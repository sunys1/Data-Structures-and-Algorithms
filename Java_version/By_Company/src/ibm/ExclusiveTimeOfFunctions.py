from typing import List
def exclusiveTime(n: int, logs: List[str]) -> List[int]:
    stack = []  # Stack to track active functions (function_id, start_time)
    result = [0] * n  # Array to store exclusive time for each function
    prev_time = 0  # Track the previous timestamp

    for log in logs:
        # Parse the log: function_id:operation:timestamp
        parts = log.split(':')
        function_id = int(parts[0])
        operation = parts[1]
        timestamp = int(parts[2])

        if operation == "start":
            # If there's a function already running, update its time
            if stack:
                prev_function_id = stack[-1][0]
                result[prev_function_id] += timestamp - prev_time
            stack.append((function_id, timestamp))
            prev_time = timestamp
        else:  # operation == "end"
            # Pop the function that just ended
            function_id, start_time = stack.pop()
            # Add the time spent in this function (exclusive)
            result[function_id] += timestamp - start_time + 1  # +1 because timestamps are inclusive
            # Update prev_time for the next function (if any)
            prev_time = timestamp + 1

    return result

# Test the solution
logs = ["0:start:0", "1:start:2", "1:end:5", "0:end:6"]
n = 2
print(exclusiveTime(n, logs))  # Output: [3, 3]