--
Move.java

A Move represents an attempt by a player to capture a tile on the Trails 
board (you'll write the board next week).  
As such, a move needs to know a few things and be able to give back 
a little bit of information about itself when asked.

An instance of the Move class (a Move object) needs to know its
x and y coordinates.
An instance of the Move class needs to be able to return those 
x and y coordinates when asked (using methods getX and getY)
An instance of the Move class needs to be able to determine if it
is the same as another move (has the same x and y coordinates).

The coordinates of a Move object will correspond to the coordinates
of a tile on the Board.  Programming your board classes will be your week
two assignment.  For this week you only need to understand how to call
methods on the board we have provided you.  For more information on the
board you will be using this week, please see the board section of the wiki.

--
Rules.java

Rules are, not surprisingly, the rules of a game of Trails.  Because
your implementation of Trails is highly customizable, it is possible
to write different sets of rules for the game.  Having said that, all
rules implement the Rules.java interface and must have certain methods.

getPlayers() returns a queue of all players in the order their turns will come.
We need this to know whose turn it is, and whose turn will come next.
For more information on queues please see: 
http://docs.oracle.com/javase/7/docs/api/java/util/Queue.html

checkForWins() checks to see if either player has won according to the
current rules set and, if a player has won, checkForWins returns that
player's color.  In a standard game of Trails a player wins when they
connect both of their sides of the board with a trail of their color, at
which point the game ends.  You will need to write two rulesets here,
one in which the first player to connect their goalpoints wins, and one
in which the first player to connect their goalpoints loses. We can do this
because hving Rules as an interface allows use to write different sets of 
rules.

isLegalMovie(Move m) takes a Move and checks with the rules to see if that
move is legal.  If the move is not legal isLegalMove returns false.  If the
move is legal, legalmove returns true.  Rules should police whether a player
can make a move.  Just because a player wants to go somewhere doesn't mean
they get to, and isLegalMove is the check against this.  For example, in the
standard rules for Trails a player cannot move to a tile on the board that
another player has already moved to.

nextTurn() moves the game to the next turn.  It is possible to use this in
different ways for different rule sets, but in the standard rules this happens
after a player has made their move and it's time for the next player's turn.

getNextPlayer() returns the player whose move will come next without making
it that player's turn and without affecting whether it will be their turn
next.  Look at the queue api documentation above if you have any questions.

makeMove(Move m) tries to make the Move m for the current player if it is 
legal and throws an InvalidMoveException if it is not legal.

getLegalMoves(Player player) returns a list of all the moves that player can
legally make this move.


--
StandardRules.java

In standard rules a player wins by being the first to connect their two
edges together by a trail of their color. Players take alternating turns
and must move exactly once on their turn.  Finally, a move can only be made
on a tile which has no color.

StandardRules will require implementations of all of the methods in Rules,
which it implements.

StandardRules will require a board instance (we are giving you a board class
you an use forr testing this week, no source code though), two player instances,
and knowledge of whose turn it is at the beginning of the game. For more
information on boards and their methods, please see the Board documentation 
in the wiki.  Please note that all Board classes will extend AbstractGameBoard.
Also pay special attention to goal nodes and their implementation, specifically
what their coordinates are.

StandardRules will need a method to tell if two tiles of a color are connected
to each other by a path of that same color on the board.

--
LoseByConnectingRules

Functions very similarly to StandardRules except that instead of winning when
they connect their two sides together, they now lose.

--
PlayerColor

PlayerColor allows for three options, RED, BLUE, and BLANK.  In StandardRules
tiles will be BLANK by default at the beginning of the game and will stay that
way until a player makes a legal move on them.

PlayerColor is an enum.  For more information on enums please see:
http://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
