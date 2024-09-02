1. Board: n*n
2. x players: player1, player2 .. player n
3. start with player 1
4. aim: whoever reaches (N-1) * (n -1) box first , multiple winners/ single winner
5. DIce: 0 - 6
6. turn - move its currpiece to next box (curr + dice result)
7. on new box: we will have to check if its a snake mouth or a ladder bottom
8. we move users piece to the next supposed box


contraints
 -> at (N-1) * (n -1), row 0 , we should not have a snake mouth,
->  top row, ladder bottom
-> 99 + dice > 1 : dont move


Dice - 1 - 6
4 players:
N * N board
winner: multi winner / single winner
each dice roll: print start box , end box , snake bitten, ladder taken


?/ optimisztions:
1. improve time complexity : k * m * n - > k
2. StrategyInjection - Factory
3. Singleton