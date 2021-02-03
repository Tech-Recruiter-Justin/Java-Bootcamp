# Hash Tables & Dictionaries

- Dictionaries essentially stores `key value pairs`
- The ideal runtime is O(1) - meaning it will always execute in the same time regardless of size of input data
	- Hash table is the good way to achieve O(1)



## Operations in a Dictionary

1. Search
2. Insert
3. Delete



## Implementation

- Three elements to create a hash table
	1. An array
	2. The dictionary that we need to represent
	3. A way to decide which index of the array is used for which key value pair

- By using a `hash function`, we can assign key value pairs to different array index
- To avoid `index collision`, a good hash should be chosen i.e. djb2, sdbm, lose lose

### Create an entry

- key -> hash -> %bucket_size -> index -> put entry

### Get an entry

- key -> hash -> %bucket_size -> index -> get entry

### Java

- When a specific linked list reached 8, Java will convert it to a tree [O(log n)]



## Chaining

- In case collision happens, we can store key value pairs in a link list

- The new key value pair added will be at the top of the link list with pointers

- Runtime for each operation

	- Insertion: O(1)

	- Search: O(1 + ⍺), ⍺ = how full the link list is

	- Delete: O(1)

		

## Open Addressing/ Linear Probing

- Store the new data to the right of the equation, if already occupied move right to prob for an empty slot
- Could become inefficient when the table grows in size

### Double Hashing 

- Determine how far in the array you probe using a second hash function
- gcd(c,m) = 1
- m should be a prime number



## Threading and Stress Test

- Given 1000 threads and 1000 request, the count may not be 1000 (972)

### What is a Thread? What is a Process?

- Process could be an application running on the OS, an instance of the progreamme, they each have their own memory
- There could be multiple threads in one process, WITHIN the process, memories could be shared (HEAP)

### Thread Safety

1. Lock
2. Synschronized keyword
	- class
	- method
	- code block
3. AtomicInteger
	- all or nothing operation

4. ConcurrentHashMap
	- lock stripping

### Fork / Join

- In case the process is not reliant on others, fork / join allows the program to merge at a subsequent point and resume sequential execution



## HTTPS (Bonus)

1. Assymmetric encryption

- Public key and private key pair removes the risk of sharing the key

2. Symmetric encryption

- More risk as the data is exposed if one side of keyholders is compromised

3. CA cert

