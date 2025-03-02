# Created on iPad.

def getMinCores(start, end):
    n = len(start)
    # Create events for start and end times
    events = []
    for i in range(n):
        events.append((start[i], 1))  # 1 for process starting
        events.append((end[i], -1))   # -1 for process ending
    print(events)
    # Sort events by time; if times are equal, prioritize end events (-1) over start events (1)
    events.sort(key=lambda x: (x[0], -x[1]))
    print(events)
    current_cores = 0
    max_cores = 0
    
    # Process events in order
    for time, event in events:
        current_cores += event  # Add 1 for start, subtract 1 for end
        max_cores = max(max_cores, current_cores)
    
    return max_cores

# Example usage
start = [1, 3, 4]
end = [3, 5, 6]
print(getMinCores(start, end))  # Output: 2
