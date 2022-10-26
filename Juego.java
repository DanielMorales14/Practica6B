/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mastermind2;

import java.util.Arrays;
import java.util.Scanner;

public class Juego {
    private String [] masterPattern;
	private String masterPatternString = "";
	private String [] remainingPossibleGuesses;
	private AciertosTotales allPossibleGuesses = new AciertosTotales();
	private int currentGuess = 0;
	private String currentGuessString = "";
	int redPegs = 0;
	int whitePegs = 0;
	private String [] remainingPossibleGuesses2;
	Integer [] pegs = new Integer[ 2 ];
	private int Guess = 1;
	private boolean firstMove = true;
	boolean hasWon = false;
	private static final String [][] gameBoard = new String [ 10 ][  ];
	
	

	public Juego( String [] colors, int positions ) {
		Scanner input = new Scanner( System.in );
		remainingPossibleGuesses2 = allPossibleGuesses.totalGuesses( positions, colors.length );
		remainingPossibleGuesses = new String[ remainingPossibleGuesses2.length ];
		masterPattern = new String[ positions ];

		System.out.println( "Has seleccionado " + positions + " lugares." );

		String [] empty = new String[ positions ];
		switch( positions ) {
		case 1 -> empty[ 0 ] = "_";
		case 2 -> {
                    empty[ 0 ] = "_";
                    empty[ 1 ] = "_";
            }
		case 3 -> {
                    empty[ 0 ] = "_";
                    empty[ 1 ] = "_";
                    empty[ 2 ] = "_";
            }
		case 4 -> {
                    empty[ 0 ] = "_";
                    empty[ 1 ] = "_";
                    empty[ 2 ] = "_";
                    empty[ 3 ] = "_";
            }
		case 5 -> {
                    empty[ 0 ] = "_";
                    empty[ 1 ] = "_";
                    empty[ 2 ] = "_";
                    empty[ 3 ] = "_";
                    empty[ 4 ] = "_";
            }

		}

		for( int i = 0; i < gameBoard.length; i++ ) {
			gameBoard[ i ] = empty.clone();
		}


		System.out.println( "Has elegido " + colors.length + " colors. \nColores disponibles:" );
		for( int i = 0; i < colors.length; i++ ) {
			System.out.println( "#" + ( i + 1 ) + ". " + colors[i] );
		}

		String [] nums = { "Primero", "Segundo", "Tercero", "Cuarto", "Quinto" };
		System.out.println( "Elija un patron. \n" );
		for( int i = 0; i < positions; i++ ) {
			System.out.println( nums[ i ] + " Color: " );
			String colorIn = input.next();
			masterPattern[ i ] = colorIn;
		}

		for( int i = 0; i < masterPattern.length; i++ ) {
			String color = masterPattern[ i ];
			switch( color ) {
			case "Azul": color = "1";
			break;
			case "Verde": color = "2";
			break;
			case "Rojo": color = "3";
			break;
			case "Amarillo": color = "4";
			break;
			case "Naranja": color = "5";
			break;
			case "Blanco": color = "6";
			break;
			case "Negro": color = "7";
			break;
			case "Cafe": color = "8";
			break;
			default: color = "Color invalido";
			break;
			}
			masterPatternString = masterPatternString + color;
		}

		System.out.println();
	}
	
	
	
	public void printBoard( int guesses, int positions, String masterPattern, int guess ) {
		String answer = "|";
		for( int j = 0; j < positions; j++ ) { 
			answer = answer + masterPattern.substring( j, j + 1 );
		}
		System.out.println( "Codigo    : " + answer + "|" );
		
		System.out.println( "___________________" );
		for( int i = 0; i < gameBoard.length; i++ ) {
			if( i == guess ) {
				for( int j = 0; j < gameBoard[ i ].length; j++ ) {
					gameBoard[ i ][ j ] = currentGuessString.substring( j, j + 1 );
				}
				System.out.println( "Intento #" + i + ". " + "|" + currentGuessString + "|"  );
			} else {
				System.out.println( "Intento #" + i + ". " + "|" + printArray( gameBoard[ i ] ) + "|"  );
			}
		}
		System.out.println( "___________________" );
	}

	public String printArray( String [] array ) {
		String row = "";
		for( int i = 0; i < array.length; i++ ) {
			row = row + array[ i ];
		}
		return row;
	}
	
	

	public String [] nextMove() {
		if( firstMove ) {
			if( masterPattern.length == 5 ) {
				currentGuess = 11222;
				currentGuessString = "" + currentGuess;
				firstMove = false; 
			} else
				currentGuess = 1122;
			currentGuessString = "" + currentGuess;
			firstMove = false;
		} else {
			patternChecker();
				currentGuessString = remainingPossibleGuesses2[ 0 ]; 
		}

		String [] currentGuessArray = new String[ masterPattern.length ];
		for( int i = 0; i < masterPattern.length; i++ ) {
			String color = currentGuessString.substring( i, i + 1 );
			switch( color ) {
			case "1" -> color = "Azul";
			case "2" -> color = "Verde";
			case "3" -> color = "Rojo";
			case "4" -> color = "Amarillo";
			case "5" -> color = "Naranja";
			case "6" -> color = "Blanco";
			case "7" -> color = "Negro";
			case "8" -> color = "Cafe";
			}
			currentGuessArray[i] = color;
		}
		
		System.out.println();
		System.out.println();

		System.out.println( "El patron de Mastermind es: " );
		String pattern = "";
		for( int i = 0; i < masterPattern.length; i++ ) {
			if( i == masterPattern.length - 1 ) {
				pattern = pattern + masterPattern[ i ];
			} else {
				pattern = pattern + masterPattern[ i ] + ", ";
			}
		}
		System.out.println( "[ " + pattern + " ]" );

		String guess = "";
		for( int i = 0; i < currentGuessArray.length; i++ ) {
			if( i == masterPattern.length - 1 ) {
				guess = guess + currentGuessArray[ i ];
			} else {
				guess = guess + currentGuessArray[ i ] + ", ";
			}
		}
		System.out.println(  "Intento #" + Guess + ". [ " + guess + " ]" );

		printBoard( 10, gameBoard[ 0 ].length, masterPatternString, Guess - 1 );
		Guess++;
		checkWin( currentGuessArray );
		return currentGuessArray;
	}
	
	

	public Integer[] pegCounter() {
		whitePegs = 0;
		redPegs = 0;
		for( int j = 0; j < masterPattern.length; j++ ) {
			boolean check = true;
			if( ( currentGuessString.substring( j, j + 1 ).equals( masterPatternString.substring( j, j + 1 ) ) ) ) {
				redPegs++;
				check = false;
				/*I included the check = false here because now, the jth spot in the currentGuessString
				will not be tested again because it has been linked up to a red peg. The white peg will
				not try to test it. If the white did test it, there would be errors.*/
			}
			for( int k = 0; k < masterPattern.length; k++ ) {
				if( check ) {
					if( currentGuessString.substring( j, j + 1 ).equals( masterPatternString.substring( k, k + 1 ) ) ) {
						if( !( currentGuessString.substring( k, k + 1 ).equals( masterPatternString.substring( k, k + 1 ) ) ) ) {
							whitePegs++;
							check = false;
						}

						if( j == k ) {
							whitePegs--;
						}
					} 
				}
			}
		}
		pegs[ 0 ] = redPegs;
		pegs[ 1 ] = whitePegs;	
		whitePegs = 0;
		redPegs = 0;

		return pegs;
	}

	public void response() {
		System.out.println( "Hay " + pegs[ 0 ] + " colores correctos en la "
				+ "posicion correcta (Puntos rojos)" );
		System.out.println( "Hay " + pegs[ 0 ] + " colores correctos en la "
				+ "posicion incorrecta (Puntos blancos)" );
	}
	
	

	public void checkWin( String [] currentGuessArray ) {
		if( Arrays.deepEquals( masterPattern, currentGuessArray ) ) {
			System.out.println( "He adivinado todos los colores." );
			hasWon = true;
		}
	}
	
	

	public void newGame() {
		String [] masterPattern;
		String masterPatternString = "";
		String [] remainingPossibleGuesses = new String[ 1296 ];
		AciertosTotales allPossibleGuesses = new AciertosTotales();
		int currentGuess = 0;
		String currentGuessString = "";
		int redPegs = 0;
		int whitePegs = 0;
		String [] remainingPossibleGuesses2;
		Integer [] pegs = new Integer[ 2 ];
		int Guess = 1;
		boolean firstMove = true;
		boolean hasWon = false;
	}
	
	

	public String [] patternChecker() {
		for( int i = 0; i < remainingPossibleGuesses2.length; i++ ) {
			if( remainingPossibleGuesses2[ i ] != null ) {
				for( int j = 0; j < masterPattern.length; j++ ) {
					boolean check = true;
					if( ( currentGuessString.substring( j, j + 1 ).equals( remainingPossibleGuesses2[ i ].substring( j, j + 1 ) ) ) ) {
						redPegs++;
						check = false;
						
					}
					for( int k = 0; k < masterPattern.length; k++ ) {
						if( check ) {
							if( currentGuessString.substring( j, j + 1 ).equals( remainingPossibleGuesses2[i].substring( k, k + 1 ) ) ) {
								if( !( currentGuessString.substring( k, k + 1 ).equals( remainingPossibleGuesses2[i].substring( k, k + 1 ) ) ) ) {
									whitePegs++;
									check = false;
								}

								if( j == k ) {
									whitePegs--;
								}
							}
						} 
					}
				}
				if( redPegs == pegs[0] && whitePegs == pegs[1] ) { 
					remainingPossibleGuesses[ i ] = remainingPossibleGuesses2[ i ];
				} else {
					remainingPossibleGuesses[ i ] = null;
				}
				redPegs = 0;
				whitePegs = 0;
			}

		}
		return newArray( remainingPossibleGuesses );
	}
	
	

	public String [] newArray( String [] array ) {
		int count1 = 0;
		int count2 = 0;
        for (String array1 : array) {
            if (array1 == null) {
                count1++;
            }
        }
		String [] newArray = new String[ array.length - count1 ];
		for( int i = 0; i < array.length; i++ ) {
			if( array[i] == null ) {
				count2++;
			} else {
				newArray[ i - count2 ] = array[ i ];
			}
		}

		remainingPossibleGuesses2 = new String[newArray.length];
		remainingPossibleGuesses2 = newArray;
		remainingPossibleGuesses = newArray;
		return remainingPossibleGuesses;
	}
}
