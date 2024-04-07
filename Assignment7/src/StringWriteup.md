For this assignment, I implemented the Lempel Ziv compression and decompression algorithm. I ran a few texts of various 
sizes to compare how the algorithm performs with the different input sizes. The longest text I could find was "Don
Quixote" which was a little less than 2.4 million bytes and compressed to about 1.6 million bytes with my algorithm.
This was a noticeable reduction of 32% in size. I included the results for all the other texts I ran in a table
below. Unsurprisingly, the longest text saw the largest size in reduction, but the reduction from "Don Quixote" to the 
next largest text, "Pride and Prejudice" was not corresponding to the differences in input size at all. Although "Don
Quixote" is more than tripe the size (about 1.7 million bytes) of "Pride and Prejudice" the difference in percent 
reduced in compression is only 5%. This is about the same amount of difference in percent reduced as "Pride and 
Prejudice" and "The Scarlet Letter," even though these two texts are only difference in size of about 250,000 bytes.
This is perhaps due to the structure of the text itself, perhaps "Don Quixote" does not have as many repeated sections 
as "Pride and Prejudice" or "The Scarlet Letter." As expected, as the size of the texts decrease, so does the percent
reduced. The smallest text, "Green Eggs and Ham" did not reduce in size after running the Lempel Ziv algorithm, and 
instead increased in size by about 13.7%. I thought this was surprising, not because of the small size of the text, but
more so because I chose the text for its repetitiveness. I found that Lempel Ziv is supposed to reduce file sizes by 
about half by searching online. Although the texts may just be too small to realize this, there may be (are) limitations
to my implementation. My codebook is never rewritten, so the algorithm cannot really adapt to the text changing, and
there are definitely many other changes I can make. 


| Text                | Input Size (bytes) | Compressed Size (bytes) | % Reduced |
|:--------------------|:------------------:|:-----------------------:|:---------:|
| Don Quixote         |      2391721       |         1620972         |   32.2%   |
| Pride and Prejudice |       772420       |         554665          |   28.2%   |
| The Scarlet Letter  |       526290       |         403169          |   23.4%   |
| A Man of Means      |       177393       |         153619          |   13.4%   |
| Green Eggs and Ham  |        3475        |          3952           |  -13.7%   |
