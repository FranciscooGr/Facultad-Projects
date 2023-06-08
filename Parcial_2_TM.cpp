#include<iostream>
#include<ctime>
#include<cstdlib>
#include<windows.h>
using namespace std;

const int fila = 6;
const int columna = 6;
const int amountPlayers = 2;
const int boardsize = 36;
const int numsnk = 2;
const int numladder = 3;
int turno;
struct scoreplayer {
    char name[20];
    int points;
};

scoreplayer player[amountPlayers][2];

int board[fila][columna] = { {0} };


int rollgiven() {  //da el valor del dado
    return rand() % 6 + 1;
}

void title() {
    cout << "------------------" << endl;
    cout << "INICIO DE PARTIDA" << endl;
    cout << "------------------" << endl;
    cout << endl;
}

void finish(const char* playerName) {
    cout << "------------------" << endl;
    cout << "FIN DE LA PARTIDA " << endl;
    cout << "------------------" << endl;
    cout << "------------------" << endl;
    cout << "   " << playerName << " HAS GANADO   " << endl;
    cout << "------------------" << endl;
}

void printsnk() {
    // Serpientes
    board[0][2] = 9;
    board[3][3] = 9;
    // Escaleras
    board[2][5] = 3;
    board[5][1] = 3;
    board[5][4] = 3;
}

void printboard(int players[]) {
    int i, j;

    for (i = 0; i < 6; i++) {
        for (j = 0; j < 6; j++) {
        	//Controlador del Jugador 2 de si cae en serpientes o escaleras
        	if(players[1]== 2){
            	players[1]= players[1] + (columna * 2);
			}            
			
            if(players[1]== 21){
            	players[1]= players[1] + (columna * 2);
			}    			
			
			if(players[1]== 17){
            	players[1]= players[1] - 6;
			}  
			if(players[1]== 31){
            	players[1]= players[1] - 6;
			} 
			if(players[1]== 34){
            	players[1]= players[1] - 6;
			} 
			
			//Controlador del Jugador 1 de si cae en serpientes o escaleras
        	if(players[0]== 2){
            	players[0]= players[0] + (columna * 2);
			}            
			
            if(players[0]== 21){
            	players[0]= players[0] + (columna * 2);
			}    			
			
			if(players[0]== 17){
            	players[0]= players[0] - 6;
			}  
			if(players[0]== 31){
            	players[0]= players[0] - 6;
			} 
			if(players[0]== 34){
            	players[0]= players[0] - 6;
			} 			
        	
        	//dibuja a los jugadores 1 y 2 en sus respectivas posiciones
            if (i == players[0] / columna && j == players[0] % columna) {
                board[i][j] = 0;
                cout << "X";
            }
            else if (i == players[1] / columna && j == players[1] % columna) {
                board[i][j] = 0;
                cout << "Y";
            }
            else {
                cout << board[i][j];
            }
            printsnk();
            cout << "  ";
        }
        cout << endl;
    }
}

int playgame() {
    int players[amountPlayers] = { 0 };
   
    turno = 0;
    int cont = 0;
    bool endgame = false;
    int x, cantroll, option;
    cantroll = 0;
    title();

    for (x = 0; x < amountPlayers; x++) {
        cout << "Ingrese el nombre del Jugador " << x + 1 << ": ";
        cin >> player[x][0].name;
        cout << endl;
    }

    do {

		        for (x = 0; x < amountPlayers; x++) {
		            cout << endl;
		            cout << endl;
		            cout << "Turno del Jugador " << player[x][0].name << endl;
		            cout << endl;
		            cout << "Presiona enter para tirar el dado: " << endl;
		            cin.ignore();
		            cin.get();
		            cantroll = cantroll + 1;
		            int roll = rollgiven();
		            cout << player[x][0].name << " Obtuviste un: " << roll << endl;
		            int newposition = players[x] + roll;   //dado mas la posicion
		
		            if (newposition > boardsize)
		                newposition = boardsize - (newposition - boardsize);// rebote de la matriz
		
		            if (newposition == boardsize) {
		                finish(player[x][0].name);
		                player[x][0].points = player[x][0].points + 150 - (cantroll); //Se resta la cantidad de tiradas menos 150
		                cout << endl;
		                cout << endl;
		                cont= cont + 1;
		                if (cont == amountPlayers) {
		                    endgame = true;
		                }
		            
						
		                cout<<"(1) JUGAR "<<endl;
		                cout<<"(2) SALIR "<<endl;
		                cin>> option;
			                	switch(option){
			                		case 1: ;
			                				if(cont == amountPlayers){     //controlador si la cantidad de jugadas ya esta en el limite
												cout<< "Se a superado el limite de jugadas, Vuelve a empezar de 0 "<<endl;
												cout<< endl;
			                					endgame=true;
			                					break;
											}
											if(cont < amountPlayers){
											
												title();
												break;
											}
			                				break;
			                		case 2: 
											cont=2;
											endgame= true;
			                				break;
								}
	
		            	players[0]=0;
		            	players[1]=0;
		            	
		            }
		            if(newposition < boardsize) {
		                players[x] = newposition;
		                printboard(players);
		            }
		        }
		        
    } while (!endgame);
    
    if(player[0][0].points > player[1][0].points){
    	
    	cout<< "El Jugador con mas puntos es: "<< player[0][0].name<< " Con: "<< player[0][0].points<< " Puntos"<< endl;
    }
    if(player[1][0].points > player[0][0].points){
    	
    	cout<< "El Jugador con mas puntos es: "<< player[1][0].name<< " Con: "<< player[1][0].points<< " Puntos"<< endl;
    }

    return turno;
}

int main() {
    srand(time(0));
    playgame();
    return 0;
}
