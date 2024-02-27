---
title: "Summary of New Frontier Sorting Algorithm"
author: "Kelly Yang"
date: "2/26/2024"
---
Mankowitz, D.J., Michi, A., Zhernov, A. *et al*. Faster sorting algorithms discovered using deep reinforcement learning. 
*Nature* 618, 257–263 (2023). https://doi.org/10.1038/s41586-023-06004-9 

Researchers of this paper implemented a deep reinforcement learning (DRL) model to optimize sorting algorithms at the 
low-level CPU level in order to formulate the discovery of new, more efficient sorting algorithms. To do this, the model
named AlphaDev was trained to play a single-player, “AssemblyGame.” The purpose of the game is for the player, in this 
case AlphaDev, to choose a series of low-level CPU level instructions to combine, which would yield a new sorting 
algorithm. Although the concept sounds simple explained like this, it is actually extremely difficult to get an 
algorithm that is provably correct and more efficient than existing algorithms considering the vast size of the search 
space. The authors compare the size to challenging games like chess and Go, which have search spaces of 10^120 an 10^700
respectively. AlphaDev was trained as an extension of a previously trained DRL algorithm, AlphaZero which uses neural 
network. To execute machine code, the authors compiled code using assembly. Transformers, which are natural text 
encoders successful with language models, were used to model the assembly instructions. As a reward signal to AlphaDev, 
two value function heads were defined: (1) predicting algorithm correctness, and (2) predicting algorithm latency. When 
it comes to what was actually discovered, AlphaDev discovered two “techniques” that can be deployed to minimize 
instructions. The actual specifics are difficult to understand, but from the images of the pseudocode, we can see that 
four lines turned into three, and five lines turned into four. The two techniques are called the AlphaDev swap move and 
the AlphaDev copy move. This improved the fixed sorts of small sizes, such as sort 3, sort 4, and sort 5. These sorts 
have been integrated into the LLVM standard C++ sort library using the new method.









