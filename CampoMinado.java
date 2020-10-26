import java.util.Random;
import java.util.Scanner;


public class CampoMinado {
	public static void main(String[] args) {
		
		String[][] campo, campoM;
		int play=1, i, j, mina, opc, lin, col, cont, l, c, l1, c1, l2, c2, contV=0;
		
		
		Scanner teclado = new Scanner(System.in);
		
		
		campo = new String[12][12];
		campoM = new String[12][12];
		
		//COLOCA AS MINAS NO CAMPO ALEATORIAMENTE
		for(i=1;i<11;i++) {
			for(j=1;j<11;j++) {
				mina = new Random().nextInt(5);
				if(mina==1) {
					campo[i][j]="@";
				}else {
					campo[i][j]=":";
				}
				campoM[i][j]=campo[i][j];
			}
		}
		
		for(i=1;i<11;i++) {
			for(j=1;j<11;j++) {
				if(campoM[i][j]=="@") {
					contV=contV+1;
				}
			}
		}
		
		while(play==1) {		
			
			//COLA PARA TESTE -----------------
			System.out.print(" ");
			for(i=1;i<11;i++) {
				System.out.print("   "+i);
			}
			System.out.print("\n  -----------------------------------------");
			for(i=1;i<11;i++) {
				if(i==10) {
					System.out.print("\n"+i+"|");
				}else {
					System.out.print("\n"+i+" |");
				}
				for(j=1;j<11;j++) {
					if(campo[i][j]=="@" || campo[i][j]==":") {
						System.out.print(" "+campo[i][j]+" |");
					}else if(campo[i][j]=="/" || campo[i][j]=="#") {
						System.out.print(" "+campo[i][j]+" |");
					}else {
						System.out.print("["+campo[i][j]+"]|");
					}
				}
				System.out.print("\n  -----------------------------------------");
			}
			System.out.print("\n\n\n\n");
			//------------------------------------
			
			
			
			
			
			//MOSTRA O CAMPO------------------------
			System.out.print("\n\n ");
			for(i=1;i<11;i++) {
				System.out.print("   "+i);
			}
			System.out.print("\n  -----------------------------------------");
			for(i=1;i<11;i++) {
				if(i==10) {
					System.out.print("\n"+i+"|");
				}else {
					System.out.print("\n"+i+" |");
				}
				for(j=1;j<11;j++) {
					if(campo[i][j]=="@" || campo[i][j]==":") {
						System.out.print("   |");
					}else if(campo[i][j]=="/" || campo[i][j]=="#") {
						System.out.print(" "+campo[i][j]+" |");
					}else {
						System.out.print("["+campo[i][j]+"]|");
					}
				}
				System.out.print("\n  -----------------------------------------");
			}
			//---------------------------------------
			
			System.out.println("\n1-MARCAR CAMPO");
			System.out.println("2-MARCAR MINA");
			System.out.println("3-DESMARCAR MINA");
			opc = teclado.nextInt();
			switch(opc) {
				case 1:
					lin=1;
					col=1;
					while(lin!=0 || col!=0) {
						cont=0;
						System.out.println("\nMARCAR CAMPO");
						System.out.println("Digite 0 para sair");
						System.out.println("Digite as coordenadas");
						System.out.print("LINHA: ");
						lin = teclado.nextInt();
						if(lin==0) {
							break;
						}
						System.out.print("COLUNA: ");
						col = teclado.nextInt();
						if(col==0) {
							break;
						}
						
						if(lin<0 || lin>10 || col<0 || col>10) {
							System.out.println("Coordenadas inválidas\nTENTE NOVAMENTE");
							break;
						}
						
						//VERIFICA SE EXPLODIU UMA MINA
						if(campoM[lin][col]=="@") {
							//SE EXPLODIU, MOSTRA O CAMPO E AS MINAS
							System.out.print(" ");
							for(i=1;i<11;i++) {
								System.out.print("   "+i);
							}
							System.out.print("\n  -----------------------------------------");
							for(i=1;i<11;i++) {
								if(i==10) {
									System.out.print("\n"+i+"|");
								}else {
									System.out.print("\n"+i+" |");
								}
								for(j=1;j<11;j++) {
									if(campo[i][j]=="@") {
										System.out.print(" "+campo[i][j]+" |");
									}else if(campo[i][j]==":"){
										System.out.print("   |");
									}else if(campo[i][j]=="/" || campo[i][j]=="#") {
										System.out.print(" "+campo[i][j]+" |");
									}else {
										System.out.print("["+campo[i][j]+"]|");
									}
								}
								System.out.print("\n  -----------------------------------------");
							}
							System.out.println("\nVOCÊ EXPLODIU UMA MINA");
							System.out.println("------FIM DE JOGO------");
							play=0;
							break;
						//SE NÃO EXPLODIU, CALCULA QUANTAS MINAS TEM EM VOLTA DO LUGAR MARCADO
						}else {
							
							for(i=lin-1;i<lin+2;i++) {
								for(j=col-1;j<col+2;j++) {
									if(campoM[i][j]=="@") {
										cont=cont+1;
									}
								}
							}
							if(cont==0) {
								campo[lin][col]="/";
							}else {
								campo[lin][col]=""+cont;
							}
							//AVISO: TRECHO GIGANTE DE FORs A BAIXO
							//SE CASO NÃO ENCONTRAR MINA EM UM RAIO DE 1 QUADRADO DO PONTO SELECIONADO
							//FAZ A VERIFICAÇÃO EM UMA RAIO DE 2 QUADRADOS DO PONTO SELECIONADO
							if(cont==0) {
								for(i=lin-1;i<lin+2;i++) {
									for(j=col-1;j<col+2;j++) {
										for(l=i-1;l<i+2;l++) {
											for(c=j-1;c<j+2;c++) {
												if(c<0 || c>11 || l<0 || l>11) {
												}else if(campoM[l][c]=="@") {
													cont=cont+1;
												}
											}
										}
						
										if(cont==0) {
											campo[i][j]="/";
										}else {
											campo[i][j]=""+cont;
										}
										//SE CASO NÃO ENCONTRAR MINA EM UM RAIO DE 2 QUADRADO DO PONTO SELECIONADO
										//FAZ A VERIFICAÇÃO EM UMA RAIO DE 3 QUADRADOS DO PONTO SELECIONADO
										if(cont==0) {
											for(l=i-1;l<i+2;l++) {
												for(c=j-1;c<j+2;c++) {
													for(l1=l-1;l1<l+2;l1++) {
														for(c1=c-1;c1<c+2;c1++) {
															if(c1<0 || c1>11 || l1<0 || l1>11) {
															}else if(campoM[l1][c1]=="@") {
																cont=cont+1;
															}
														}
													}
													if(c<0 || c>11 || l<0 || l>11) {
													}else {
														if(cont==0) {
															campo[l][c]="/";
														}else {
															campo[l][c]=""+cont;
														}
													}
													//SE CASO NÃO ENCONTRAR MINA EM UM RAIO DE 3 QUADRADO DO PONTO SELECIONADO
													//FAZ A VERIFICAÇÃO EM UMA RAIO DE 4 QUADRADOS DO PONTO SELECIONADO
													if(cont==0) {
														for(l1=l-1;l1<l+2;l1++) {
															for(c1=c-1;c1<c+2;c1++) {
																for(l2=l1-1;l2<l1+2;l2++) {
																	for(c2=c1-1;c2<c1+2;c2++) {
																		if(c2<0 || c2>11 || l2<0 || l2>11) {
																		}else if(campoM[l2][c2]=="@") {
																			cont=cont+1;
																		}
																	}
																}
																if(c1<0 || c1>11 || l1<0 || l1>11) {
																}else {
																	if(cont==0) {
																		campo[l1][c1]="/";
																	}else {
																		campo[l1][c1]=""+cont;
																	}
																}
																cont=0;
															}
														}
													}
													cont=0;
												}
											}
										}
										cont=0;
									}
								}
							}
							//MOSTRA O CAMPO
							System.out.print("\n\n ");
							for(i=1;i<11;i++) {
								System.out.print("   "+i);
							}
							System.out.print("\n  -----------------------------------------");
							for(i=1;i<11;i++) {
								if(i==10) {
									System.out.print("\n"+i+"|");
								}else {
									System.out.print("\n"+i+" |");
								}
								for(j=1;j<11;j++) {
									if(campo[i][j]=="@" || campo[i][j]==":") {
										System.out.print("   |");
									}else if(campo[i][j]=="/" || campo[i][j]=="#") {
										System.out.print(" "+campo[i][j]+" |");
									}else {
										System.out.print("["+campo[i][j]+"]|");
									}
								}
								System.out.print("\n  -----------------------------------------");
							}
						}
						cont=0;
						for(i=1;i<11;i++) {
							for(j=1;j<11;j++) {
								if(campo[i][j]=="#" && campoM[i][j]=="@") {
									cont=cont+1;
								}
							}
						}
						
						if(cont == contV) {
							play=0;
							break;
						}
						cont=0;
					}
				break;
				
				case 2:
					lin=1;
					col=1;
					while(lin!=0 || col!=0) {
						System.out.println("\nMARCAR MINA");
						System.out.println("Digite 0 para sair");
						System.out.println("Digite as coordenadas");
						System.out.print("LINHA: ");
						lin = teclado.nextInt();
						if(lin==0) {
							break;
						}
						System.out.print("COLUNA: ");
						col = teclado.nextInt();
						if(col==0) {
							break;
						}
						
						if(lin<0 || lin>10 || col<0 || col>10) {
							System.out.println("Coordenadas inválidas\nTENTE NOVAMENTE");
							break;
						}
						
						if(campo[lin][col]=="@" || campo[lin][col]==":") {
							campo[lin][col]="#";
							
							//MOSTRA O CAMPO
							System.out.print("\n\n ");
							for(i=1;i<11;i++) {
								System.out.print("   "+i);
							}
							System.out.print("\n  -----------------------------------------");
							for(i=1;i<11;i++) {
								if(i==10) {
									System.out.print("\n"+i+"|");
								}else {
									System.out.print("\n"+i+" |");
								}
								for(j=1;j<11;j++) {
									if(campo[i][j]=="@" || campo[i][j]==":") {
										System.out.print("   |");
									}else if(campo[i][j]=="/" || campo[i][j]=="#") {
										System.out.print(" "+campo[i][j]+" |");
									}else {
										System.out.print("["+campo[i][j]+"]|");
									}
								}
								System.out.print("\n  -----------------------------------------");
							}
							
						}else {
							System.out.println("Coordenada já marcada\nTENTE NOVAMENTE");
						}
						cont=0;
						for(i=1;i<11;i++) {
							for(j=1;j<11;j++) {
								if(campo[i][j]=="#" && campoM[i][j]=="@") {
									cont=cont+1;
								}
							}
						}
						
						if(cont == contV) {
							play=0;
							break;
						}
						cont=0;
					}
					
				break;
				
				case 3:
					lin=1;
					col=1;
						while(lin!=0 || col!=0) {
						System.out.println("\nDESMARCAR MINA");
						System.out.println("Digite 0 para sair");
						System.out.println("Digite as coordenadas");
						System.out.print("LINHA: ");
						lin = teclado.nextInt();
						if(lin==0) {
							break;
						}
						System.out.print("COLUNA: ");
						col = teclado.nextInt();
						if(col==0) {
							break;
						}
						
						if(lin<0 || lin>10 || col<0 || col>10) {
							System.out.println("Coordenadas inválidas\nTENTE NOVAMENTE");
							break;
						}
						
						
						if(campo[lin][col]=="#") {
							campo[lin][col]=campoM[lin][col];
							
							//MOSTRA O CAMPO
							System.out.print("\n\n ");
							for(i=1;i<11;i++) {
								System.out.print("   "+i);
							}
							System.out.print("\n  -----------------------------------------");
							for(i=1;i<11;i++) {
								if(i==10) {
									System.out.print("\n"+i+"|");
								}else {
									System.out.print("\n"+i+" |");
								}
								for(j=1;j<11;j++) {
									if(campo[i][j]=="@" || campo[i][j]==":") {
										System.out.print("   |");
									}else if(campo[i][j]=="/" || campo[i][j]=="#") {
										System.out.print(" "+campo[i][j]+" |");
									}else {
										System.out.print("["+campo[i][j]+"]|");
									}
								}
								System.out.print("\n  -----------------------------------------");
							}
						}else {
							System.out.println("Coordenada não está marcada\nTENTE NOVAMENTE");
						}
						cont=0;
						for(i=1;i<11;i++) {
							for(j=1;j<11;j++) {
								if(campo[i][j]=="#" && campoM[i][j]=="@") {
									cont=cont+1;
								}
							}
						}
						
						if(cont == contV) {
							play=0;
							break;
						}
						cont=0;
					}
					
				break;
				
				
			}
			
			cont=0;
			
			for(i=1;i<11;i++) {
				for(j=1;j<11;j++) {
					if(campo[i][j]=="#" && campoM[i][j]=="@") {
						cont=cont+1;
					}
				}
			}
			
			if(cont == contV) {
				play=0;
				System.out.println("\nTODAS AS MINAS FORAM MARCADAS");
				System.out.println("   ------VOCÊ VENCEU------");
			}
			
		}
		
		teclado.close();
		
	}
}
