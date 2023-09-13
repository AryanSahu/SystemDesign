package com.study.coding.ds;

import java.util.*;

public class IntervalsPractise {

    public static void main(String[] args) {



    }


    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int ans = 0;
        int currentEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; ++i)
            if (intervals[i][0] >= currentEnd)
                currentEnd = intervals[i][1];
            else
                ++ans;

        return ans;
    }


    public int minMeetingRooms(int[][] intervals) {
        // Sort intervals by their start times
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Store end times of each room in a minHeap
        Queue<Integer> minHeap = new PriorityQueue<>();


        for (int[] interval : intervals) {
            // Check if there's an available room (no overlap)
            if (!minHeap.isEmpty() && interval[0] >= minHeap.peek()) {
                minHeap.poll(); // Reuse the room
            }

            minHeap.offer(interval[1]); // Add the end time of the current meeting
        }

        return minHeap.size(); // The size of the minHeap represents the required rooms
    }

    public boolean canAttendMeetings(int[][] intervals) {
        // Sort intervals by their start times
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i = 1; i < intervals.length; ++i) {
            // If the end time of the previous interval is greater than or equal to
            // the start time of the current interval, there is an overlap
            if (intervals[i - 1][1] >= intervals[i][0]) {
                return false; // Cannot attend all meetings
            }
        }

        return true; // Can attend all meetings without overlapping
    }

    private static void insertInterval() {
        int [][]intervals={{},{}};
        int [] newInterval={};

        int i=0;
        int n=intervals.length;

        List<int[]> result=new ArrayList<>();


        // insert intervals before new interval
        while(i<n && intervals[i][1]<newInterval[0])
        {

             result.add(intervals[i]);
             i++;
        }


         // merge intervals
        while(i<n && intervals[i][0]<=newInterval[1])
        {
            newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
            newInterval[1]=Math.min(intervals[i][1],newInterval[1]);
            i++;
        }

        result.add(newInterval);


        // after left over intervals
        while(i<n)
        {
            result.add(intervals[i]);

        }
    }


    private static void mergeIntervals() {
        int intervals[][]={{1,3},{2,4},{2,6},{8,9},{8,10},{9,11},{15,18},{16,17}};

        // Sort intervals by their start values
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> mergeIntervals = new ArrayList<>();

        int[] currentInterval = intervals[0];

        for (int[] interval : intervals) {
            if (interval[0] <= currentInterval[1]) {
                // Merge overlapping intervals
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                // Disjoint intervals, add the current one and update currentInterval
                mergeIntervals.add(currentInterval);
                currentInterval = interval;
            }
        }

        // Add the last interval
        mergeIntervals.add(currentInterval);

        // Print merged intervals
        for (int[] mergedInterval : mergeIntervals) {
            System.out.println(Arrays.toString(mergedInterval));
        }
    }

}
