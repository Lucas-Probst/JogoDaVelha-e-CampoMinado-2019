import java.util.Scanner;

public class JogoDaVelha {
	public static void main(String[] args) {
		
		String[][] mesa;
		int vez=1, play=1, valor, cont, i, j;
		
		//String player1, player2;
		
		Scanner teclado = new Scanner(System.in);
		
		/*System.out.print("Digite o nome do Jogador 1: ");
		player1 = teclado.nextLine();
		
		System.out.print("\nDigite o nome do jogador 2: ");
		player2 = teclado.nextLine();*/

		mesa = new String[3][3];
		mesa[0][0] = "1";
		mesa[0][1] = "2";
		mesa[0][2] = "3";
		mesa[1][0] = "4";
		mesa[1][1] = "5";
		mesa[1][2] = "6";
		mesa[2][0] = "7";
		mesa[2][1] = "8";
		mesa[2][2] = "9";
		
		while(play==1) {
			
			cont=0;
			
			if(vez==1) {
				while(vez==1) {
					System.out.println("______________________________________\n");
					System.out.println("\n\t       |       |       ");
					System.out.println("\t   "+mesa[0][0]+"   |   "+mesa[0][1]+"   |   "+mesa[0][2]+"   ");
					System.out.println("\t_______|_______|_______");
					System.out.println("\t       |       |       ");
					System.out.println("\t   "+mesa[1][0]+"   |   "+mesa[1][1]+"   |   "+mesa[1][2]+"   ");
					System.out.println("\t_______|_______|_______");
					System.out.println("\t       |       |       ");
					System.out.println("\t   "+mesa[2][0]+"   |   "+mesa[2][1]+"   |   "+mesa[2][2]+"   ");
					System.out.println("\t       |       |       ");
					
					System.out.println("\n\t     --JOGADOR 1--\n");
					System.out.print("Escolha uma posição: ");
					valor = teclado.nextInt();
					System.out.println("");
					
					if(valor==1 && mesa[0][0]=="1") {
						vez=2;
						mesa[0][0]="X";
					}else if(valor==2 && mesa[0][1]=="2") {
						vez=2;
						mesa[0][1] = "X";
					}else if(valor==3 && mesa[0][2]=="3") {
						vez=2;
						mesa[0][2] = "X";
					}else if(valor == 4 && mesa[1][0]=="4") {
						vez=2;
						mesa[1][0] = "X";
					}else if(valor == 5 && mesa[1][1]=="5") {
						vez=2;
						mesa[1][1] = "X";
					}else if(valor == 6 && mesa[1][2]=="6") {
						vez=2;
						mesa[1][2] = "X";
					}else if(valor == 7 && mesa[2][0]=="7") {
						vez=2;
						mesa[2][0] = "X";
					}else if(valor == 8 && mesa[2][1]=="8") {
						vez=2;
						mesa[2][1] = "X";
					}else if(valor == 9 && mesa[2][2]=="9") {
						vez=2;
						mesa[2][2] = "X";
					}else {
						System.out.println("--Posição inválida--");
					}
				}
				
			}else if(vez==2) {
				while(vez==2) {
					
					System.out.println("______________________________________\n");
					System.out.println("\n\t       |       |       ");
					System.out.println("\t   "+mesa[0][0]+"   |   "+mesa[0][1]+"   |   "+mesa[0][2]+"   ");
					System.out.println("\t_______|_______|_______");
					System.out.println("\t       |       |       ");
					System.out.println("\t   "+mesa[1][0]+"   |   "+mesa[1][1]+"   |   "+mesa[1][2]+"   ");
					System.out.println("\t_______|_______|_______");
					System.out.println("\t       |       |       ");
					System.out.println("\t   "+mesa[2][0]+"   |   "+mesa[2][1]+"   |   "+mesa[2][2]+"   ");
					System.out.println("\t       |       |       ");
					
					System.out.println("\n\t     --JOGADOR 2--\n");
					System.out.print("Escolha uma posição: ");
					valor = teclado.nextInt();
					System.out.println("");
					
					if(valor==1 && mesa[0][0]=="1") {
						vez=1;
						mesa[0][0]="O";
					}else if(valor==2 && mesa[0][1]=="2") {
						vez=1;
						mesa[0][1] = "O";
					}else if(valor==3 && mesa[0][2]=="3") {
						vez=1;
						mesa[0][2] = "O";
					}else if(valor == 4 && mesa[1][0]=="4") {
						vez=1;
						mesa[1][0] = "O";
					}else if(valor == 5 && mesa[1][1]=="5") {
						vez=1;
						mesa[1][1] = "O";
					}else if(valor == 6 && mesa[1][2]=="6") {
						vez=1;
						mesa[1][2] = "O";
					}else if(valor == 7 && mesa[2][0]=="7") {
						vez=1;
						mesa[2][0] = "O";
					}else if(valor == 8 && mesa[2][1]=="8") {
						vez=1;
						mesa[2][1] = "O";
					}else if(valor == 9 && mesa[2][2]=="9") {
						vez=1;
						mesa[2][2] = "O";
					}else {
						System.out.println("--Posição inválida--");
					}
				}
			}
			
			if(mesa[0][0]=="X" && mesa[0][1]=="X" && mesa[0][2]=="X") {
				play=0;
				cont=1;
				System.out.println("\t ---JOGADOR 1 VENCEU---");
			}else if(mesa[1][0]=="X" && mesa[1][1]=="X" && mesa[1][2]=="X") {
				play=0;
				cont=1;
				System.out.println("\t ---JOGADOR 1 VENCEU---");
			}else if(mesa[2][0]=="X" && mesa[2][1]=="X" && mesa[2][2]=="X") {
				play=0;
				cont=1;
				System.out.println("\t ---JOGADOR 1 VENCEU---");
			}else if(mesa[0][0]=="X" && mesa[1][0]=="X" && mesa[2][0]=="X") {
				play=0;
				cont=1;
				System.out.println("\t ---JOGADOR 1 VENCEU---");
			}else if(mesa[0][1]=="X" && mesa[1][1]=="X" && mesa[2][1]=="X") {
				play=0;
				cont=1;
				System.out.println("\t ---JOGADOR 1 VENCEU---");
			}else if(mesa[0][2]=="X" && mesa[1][2]=="X" && mesa[2][2]=="X") {
				play=0;
				cont=1;
				System.out.println("\t ---JOGADOR 1 VENCEU---");
			}else if(mesa[0][0]=="X" && mesa[1][1]=="X" && mesa[2][2]=="X") {
				play=0;
				cont=1;
				System.out.println("\t ---JOGADOR 1 VENCEU---");
			}else if(mesa[0][2]=="X" && mesa[1][1]=="X" && mesa[2][0]=="X") {
				play=0;
				cont=1;
				System.out.println("\t ---JOGADOR 1 VENCEU---");
			}
			
			if(mesa[0][0]=="O" && mesa[0][1]=="O" && mesa[0][2]=="O") {
				play=0;
				cont=1;
				System.out.println("\t ---JOGADOR 2 VENCEU---");
			}else if(mesa[1][0]=="O" && mesa[1][1]=="O" && mesa[1][2]=="O") {
				play=0;
				cont=1;
				System.out.println("\t ---JOGADOR 2 VENCEU---");
			}else if(mesa[2][0]=="O" && mesa[2][1]=="O" && mesa[2][2]=="O") {
				play=0;
				cont=1;
				System.out.println("\t ---JOGADOR 2 VENCEU---");
			}else if(mesa[0][0]=="O" && mesa[1][0]=="O" && mesa[2][0]=="O") {
				play=0;
				cont=1;
				System.out.println("\t ---JOGADOR 2 VENCEU---");
			}else if(mesa[0][1]=="O" && mesa[1][1]=="O" && mesa[2][1]=="O") {
				play=0;
				cont=1;
				System.out.println("\t ---JOGADOR 2 VENCEU---");
			}else if(mesa[0][2]=="O" && mesa[1][2]=="O" && mesa[2][2]=="O") {
				play=0;
				cont=1;
				System.out.println("\t ---JOGADOR 2 VENCEU---");
			}else if(mesa[0][0]=="O" && mesa[1][1]=="O" && mesa[2][2]=="O") {
				play=0;
				cont=1;
				System.out.println("\t ---JOGADOR 2 VENCEU---");
			}else if(mesa[0][2]=="O" && mesa[1][1]=="O" && mesa[2][0]=="O") {
				play=0;
				cont=1;
				System.out.println("\t ---JOGADOR 2 VENCEU---");
			}
			
			
			
			for(i=0;i<3;i++) {
				for(j=0;j<3;j++) {
					if(mesa[i][j]=="X" || mesa[i][j]=="O") {
						cont=cont+1;
					}
				}
			}
			
			if(cont==9) {
				play=0;
				System.out.println("  -------------DEU VELHA------------");
				System.out.println("  ----------NINGUEM VENCEU----------");
			}
			
		}
		
		System.out.println("\n\t       |       |       ");
		System.out.println("\t   "+mesa[0][0]+"   |   "+mesa[0][1]+"   |   "+mesa[0][2]+"   ");
		System.out.println("\t_______|_______|_______");
		System.out.println("\t       |       |       ");
		System.out.println("\t   "+mesa[1][0]+"   |   "+mesa[1][1]+"   |   "+mesa[1][2]+"   ");
		System.out.println("\t_______|_______|_______");
		System.out.println("\t       |       |       ");
		System.out.println("\t   "+mesa[2][0]+"   |   "+mesa[2][1]+"   |   "+mesa[2][2]+"   ");
		System.out.println("\t       |       |       ");
		
		teclado.close();
		
	}
}
