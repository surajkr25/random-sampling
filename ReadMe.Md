You are working in a software product company and the software product is being used by multiple clients. Whenever a new feature is added to the product, company needs to select a random subset of its clients to roll out the new feature in. This is needed as the company wants to see the effect of the new feature without taking the chance of alienating all its users if the rollout is unsuccessful.

Implement an algorithm that takes as input an array of distinct elements and a size, and returns a subset of the given size of the array elements. All subsets should be equally likely.

Hint: Use Collections.shuffle() method

Example:
We have a list of integers: 1 to 10 and we need a sublist of sample size of 4 integers. Every run should give different sublist of 4 integers as sample with equal likeliness.

Follow up 1
Use Collections.swap() method

Follow up 2
Online sampling on streaming data.

Network packet sniffer is designed such that to provide a uniform sample of packets for a network session.

Write a program that takes as input a size k and read packets, continuously maintaining a uniform random sample of size k of the read packets.

Youtube
https://www.youtube.com/watch?v=SjEHO2qWy7g