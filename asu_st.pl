%
% asu.pl
%
%
%Project by: Vishnu Kadaba, Adithya Mosam, Hetkumar Jagdishkumar Patel

drawHLine(0) :- write('\n').
drawHLine(N) :-
    N > 0,
    write('-'),
    N1 is N - 1,
    drawHLine(N1).

drawSymbol(Symbol, 0).
drawSymbol(Symbol, N) :-
    N > 0,
    write(Symbol),
    N1 is N - 1,
    drawSymbol(Symbol, N1).

drawVSpace(0, LineLen).
drawVSpace(N, LineLen) :-
    N > 0,
    write('|'),
    drawSymbol(' ', LineLen),
    write('|'),
    write('\n'),
    N1 is N - 1,
    drawVSpace(N1, LineLen).

asu(LeftRightMargin, TopBotMargin, TextSpace, TextFont) :-
    (\+integer(LeftRightMargin); \+integer(TopBotMargin); \+integer(TextSpace); \+integer(TextFont); TextSpace < 1; TextFont < 1; LeftRightMargin < 1; TopBotMargin < 1), !,
    write('All arguments must be positive integers.').
	
	
asu(LeftRightMargin, TopBotMargin, TextSpace, TextFont) :-
    integer(LeftRightMargin),
    integer(TopBotMargin),
    integer(TextSpace),
    integer(TextFont),
    TextSpace >= 1,
    TextFont >= 1,
    LeftRightMargin >= 1,
    TopBotMargin >= 1,
    TextWidth is TextFont * 3,
    TextHeight is TextFont * 5,
    LineLen is TextWidth * 3 + TextSpace * 2 + LeftRightMargin * 2,
    drawHLine(LineLen + 2),
    drawVSpace(TopBotMargin, LineLen),
    draw(LeftRightMargin, TopBotMargin, TextSpace, TextWidth, TextHeight, TextFont, 0),
    drawVSpace(TopBotMargin, LineLen),
    drawHLine(TextWidth * 3 + TextSpace * 2 + LeftRightMargin * 2 + 2).
    !. %Added a safety cut
    draw(LeftRightMargin, TopBotMargin, TextSpace, TextWidth, TextHeight, TextFont, TextHeight).
    draw(LeftRightMargin, TopBotMargin, TextSpace, TextWidth, TextHeight, TextFont, Line) :-
    Line < TextHeight,
    write('|'),
    drawSymbol(' ', LeftRightMargin),
    drawA(TextWidth, TextHeight, TextFont, Line, 0),
    drawSymbol(' ', TextSpace),
	
	% students need to uncomment these two lines -----------------------
    drawS(TextWidth, TextHeight, TextFont, Line, 0),
    drawSymbol(' ', TextSpace),
	
	
    drawU(TextWidth, TextHeight, TextFont, Line, 0),
    drawSymbol(' ', LeftRightMargin),
    write('|'),
    write('\n'),
    NextLine is Line + 1,
    draw(LeftRightMargin, TopBotMargin, TextSpace, TextWidth, TextHeight, TextFont, NextLine).


	% draw A----------

drawA(TextWidth, TextHeight, TextFont, Line, TextWidth).
drawA(TextWidth, TextHeight, TextFont, Line, Col) :-
    ((Line >= TextFont, Line < 2 * TextFont); (Line >= 3 * TextFont, Line < 4 * TextFont); (Line >= 4 * TextFont, Line < 5 * TextFont)),
    Col >= 0,
    Col < TextFont,
    drawSymbol('*', TextFont),
    NextCol is Col + TextFont,
    drawA(TextWidth, TextHeight, TextFont, Line, NextCol).
	
drawA(TextWidth, TextHeight, TextFont, Line, Col) :-
    ((Line >= TextFont, Line < 2 * TextFont); (Line >= 3 * TextFont, Line < 4 * TextFont); (Line >= 4 * TextFont, Line < 5 * TextFont)),
    Col >= 2 * TextFont,
    Col < 3 * TextFont,
    drawSymbol('*', TextFont),
    NextCol is Col + TextFont,
    drawA(TextWidth, TextHeight, TextFont, Line, NextCol).
	
drawA(TextWidth, TextHeight, TextFont, Line, Col) :-
    ((Line >= TextFont, Line < 2 * TextFont); (Line >= 3 * TextFont, Line < 4 * TextFont); (Line >= 4 * TextFont, Line < 5 * TextFont)),
    Col >= 1 * TextFont,
    Col < 2 * TextFont,
    drawSymbol(' ', TextFont),
    NextCol is Col + TextFont,
    drawA(TextWidth, TextHeight, TextFont, Line, NextCol).
	
drawA(TextWidth, TextHeight, TextFont, Line, Col) :-
    ((Line >= 0, Line < TextFont); (Line >= 2 * TextFont, Line < 3 * TextFont)),
    Col < 3 * TextFont,
    drawSymbol('*', TextFont),
    NextCol is Col + TextFont,
    drawA(TextWidth, TextHeight, TextFont, Line, NextCol).


	% draw S----------Studnets need to complete this predicate.

drawS(TextWidth, TextHeight, TextFont, Line, TextWidth).
%#1
%lines 0,1,4,5,8,9 
%coloumns: all coloumns
%expected output: [******]
drawS(TextWidth, TextHeight, TextFont, Line, Col) :-
    ((Line >= 0, Line < TextFont); (Line >= 2 * TextFont, Line < 3 * TextFont); (Line >= 4 * TextFont, Line < 5 * TextFont)),
    Col < 3*TextFont,
    drawSymbol('*', TextFont),
    NextCol is Col + TextFont,
    drawS(TextWidth, TextHeight, TextFont, Line, NextCol).

%#2
%lines 2,3
%coloumns: 0,1
%expected output: [**    ]
drawS(TextWidth, TextHeight, TextFont, Line, Col) :-
    ((Line >= TextFont, Line < 2 * TextFont)),
    Col >= 0,
    Col < TextFont,
    drawSymbol('*', TextFont),
    NextCol is Col + TextFont,
    drawS(TextWidth, TextHeight, TextFont, Line, NextCol).

%#3
%lines 6,7
%coloumns: 4,5
%expected output: [    **]
drawS(TextWidth, TextHeight, TextFont, Line, Col) :-
    ((Line >= 3*TextFont, Line < 4 * TextFont)),
    Col >= 2*TextFont,
    Col < 3*TextFont,
    drawSymbol('*', TextFont),
    NextCol is Col + TextFont,
    drawS(TextWidth, TextHeight, TextFont, Line, NextCol).

%#4
%lines 2,3
%coloumns: 2,3,4,5
%expected output: [**    ]
drawS(TextWidth, TextHeight, TextFont, Line, Col) :-
    ((Line >= TextFont, Line < 2 * TextFont)),
    Col >= TextFont,
    Col < 3*TextFont,
    drawSymbol(' ', TextFont),
    NextCol is Col + TextFont,
    drawS(TextWidth, TextHeight, TextFont, Line, NextCol).

%#5
%lines 6,7
%coloumns: 0,1,2,3
%expected output: [    **]
drawS(TextWidth, TextHeight, TextFont, Line, Col) :-
    ((Line >= 3*TextFont, Line < 4 * TextFont)),
    Col >= 0,
    Col < 2*TextFont,
    drawSymbol(' ', TextFont),
    NextCol is Col + TextFont,
    drawS(TextWidth, TextHeight, TextFont, Line, NextCol).

	
	
	% draw U----------

drawU(TextWidth, TextHeight, TextFont, Line, TextWidth).
drawU(TextWidth, TextHeight, TextFont, Line, Col) :-
    (Line >= 0, Line < 4 * TextFont),
    Col >= 0,
    Col < TextFont,
    drawSymbol('*', TextFont),
    NextCol is Col + TextFont,
    drawU(TextWidth, TextHeight, TextFont, Line, NextCol).
	
drawU(TextWidth, TextHeight, TextFont, Line, Col) :-
    (Line >= 0, Line < 4 * TextFont),
    Col >= 2 * TextFont,
    Col < 3 * TextFont,
    drawSymbol('*', TextFont),
    NextCol is Col + TextFont,
    drawU(TextWidth, TextHeight, TextFont, Line, NextCol).
	
drawU(TextWidth, TextHeight, TextFont, Line, Col) :-
    (Line >= 0, Line < 4 * TextFont),
    Col >= 1 * TextFont,
    Col < 2 * TextFont,
    drawSymbol(' ', TextFont),
    NextCol is Col + TextFont,
    drawU(TextWidth, TextHeight, TextFont, Line, NextCol).
	
drawU(TextWidth, TextHeight, TextFont, Line, Col) :-
    (Line >= 4 * TextFont, Line < 5 * TextFont),
    Col < 3 * TextFont,
    drawSymbol('*', TextFont),
    NextCol is Col + TextFont,
    drawU(TextWidth, TextHeight, TextFont, Line, NextCol).

