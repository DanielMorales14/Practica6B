/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mastermind2;

import java.util.Scanner;

public class Mastermind2 {
    public static void main( String [] args ) {
		String answer;
		do {
			String [] totalColors = { "Azul", "Verde", "Rojo", "Amarillo", "Naranja", 
					"Blanco", "Negro", "Cafe" };
			Scanner input = new Scanner( System.in );
			System.out.println("""
                                           Bienvenido a Mastermind. Resolvere tu codigo. 
                                           Elige la cantidad de casillas y colores a adivinar. """);
			System.out.println( "Intruduzca numero de casillas (entre 1 y 5): " );
			int places = input.nextInt();
			System.out.println( "Entroduce los colores que "
					+ "adivinar (entre 1 and 8) : " );
			int colors = input.nextInt();
			String [] gameColors = new String [colors];
                    System.arraycopy(totalColors, 0, gameColors, 0, colors);

			Juego master = new Juego( gameColors, places );

			System.out.println("""
                                           Muy bien, ahora mirame resolver el codigo. 
                                           Puedes responderme sies que acierto el color 
                                            y si consigo la posicion correcta.""");

			while( master.hasWon == false ) {
				master.nextMove();
				master.pegCounter();
				if( master.hasWon == false ) {
					System.out.println( "Introduce el numero de puntos rojos:" );
					System.out.println( "Introduce el numero de puntos blancos:" );
				}
				master.response();  

			}
			System.out.println( "¿Deseas jugar otra vez? \nEspero que 'Si'." );
			answer = input.next();
		} while( answer.equalsIgnoreCase( "Si" ) );

	}
}
