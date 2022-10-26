/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mastermind2;

/**
 *
 * @author Danie
 */
public class AciertosTotales {
    String [] totalGuesses;
	int num = 0;
	
	public static void main( String [] args ) {
		AciertosTotales test = new AciertosTotales();
		test.totalGuesses( 5, 6 );
	}
	
	public String [] totalGuesses() {
		int num = 0;

		for( int i = 1; i < 7; i++ ) {
			for( int j = 1; j < 7; j++ ) {
				for( int k = 1; k < 7; k++ ) {
					for( int l = 1; l < 7; l++ ) {
						totalGuesses[ num ] = i + "" + j + "" + k + "" + l;
						num++;
					}
				}
			}
		}

		return totalGuesses;
	}
	
	public String [] totalGuesses( int positions, int colors ) {
		totalGuesses = new String[ ( int )Math.pow( colors, positions ) ];
		
        switch (positions) {
            case 1 -> {
                for( int i = 1; i < colors + 1; i++ ) {
                    totalGuesses[ num ] = i + "";
                    num++;
                }
            }
            case 2 -> {
                for( int i = 1; i < colors + 1; i++ ) {
                    for( int j = 1; j < colors + 1; j++ ) {
                        totalGuesses[ num ] = i + "" + j + "";
                        num++;
                        
                    }
                }
            }
            case 3 -> {
                for( int i = 1; i < colors + 1; i++ ) {
                    for( int j = 1; j < colors + 1; j++ ) {
                        for( int k = 1; k < colors + 1; k++ ) {
                            totalGuesses[ num ] = i + "" + j + "" + k;
                            num++;
                        }
                    }
                }
            }
            case 4 -> {
                for( int i = 1; i < colors + 1; i++ ) {
                    for( int j = 1; j < colors + 1; j++ ) {
                        for( int k = 1; k < colors + 1; k++ ) {
                            for( int l = 1; l < colors + 1; l++ ) {
                                totalGuesses[ num ] = i + "" + j + "" + k + "" + l;
                                num++;
                            }
                        }
                    }
                }
            }
            case 5 -> {
                for( int i = 1; i < colors + 1; i++ ) {
                    for( int j = 1; j < colors + 1; j++ ) {
                        for( int k = 1; k < colors + 1; k++ ) {
                            for( int l = 1; l < colors + 1; l++ ) {
                                for( int m = 1; m < colors + 1; m++ ) {
                                    totalGuesses[ num ] = i + "" + j + "" + k + "" + l + "" + m;
                                    num++;
                                }
                                
                            }
                        }
                    }
                }
            }
            default -> {
            }
        }

		return totalGuesses;
	}
}
