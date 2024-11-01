#include <iostream>
#include <cmath>
#include <fstream>
using namespace std;

float JimenezN1, JimenezN2, JimenezN3, Promedio;;

void Menu ();
void Ingreso_Notas ();
void Jimenez_Promedio (float JimN1, float JimN2,float JimN3);
void GuardarTXT();
void Menu_Salir();
int main()
{
    Menu ();
    cout << "Hello world!" << endl;
    return 0;
}

void Menu (){
    int op;
    cout << "=========================="<<endl;
    cout << "1. Ingreso de notas "<<endl;
    cout << "2. Promedio "<<endl;
    cout << "3. Salir "<<endl;
    cout << "=========================="<<endl;
    cout << "Elija una opcion: ";
    cin >> op;
    switch(op){
    case 1:
        Ingreso_Notas ();
        Menu ();
        break;
    case 2:
        Jimenez_Promedio (JimenezN1, JimenezN2, JimenezN3);
        Menu ();
        break;
    case 3:
        Menu_Salir();
        break;
    default:
        cout << "OPCION INCORECTA ESCOJA OTRA"<<endl;
        Menu ();
        break;

    }

}
void Ingreso_Notas (){
    cout<< "Cual es su primer nota (0-20): ";
    cin >> JimenezN1;
    while (JimenezN1<0 || JimenezN1>20){
        cout<< "Se a pasado de los limites establecidos. Ingrese otra nota: ";
        cin >> JimenezN1;
    }

    cout<< "Cual es su segunda nota (0-20): ";
    cin >> JimenezN2;
    while (JimenezN2<0 || JimenezN2>20){
        cout<< "Se a pasado de los limites establecidos. Ingrese otra nota: ";
        cin >> JimenezN2;
    }

    cout<< "Cual es su tercer nota (0-20): ";
    cin >> JimenezN3;
    while (JimenezN3<0 || JimenezN3>20){
        cout<< "Se a pasado de los limites establecidos. Ingrese otra nota: ";
        cin >> JimenezN3;
    }

}
void Jimenez_Promedio (float JimN1, float JimN2,float JimN3){

    Promedio = (JimN1+JimN2+JimN3)/3;
    cout << "=========================="<<endl;
    cout << "Primera nota: "<<JimN1<<endl;
    cout << "Segunda nota: "<<JimN2<<endl;
    cout << "tercera nota: "<<JimN3<<endl;
    cout << "-------------------------"<<endl;
    cout << "Promedio:     "<<Promedio<<endl;
    cout << "=========================="<<endl;

}
void Menu_Salir(){
    char op;
    cout << "Deasea Guardar las notas (s/n)? ";
    cin >> op;
    switch(op){
    case 's':
        GuardarTXT();
        break;
    case 'n':

        break;
    default:
        cout << "OPCION INCORECTA ESCOJA OTRA"<<endl;
        Menu_Salir();
        break;
    }
}
void GuardarTXT(){
    ofstream archivo;
    archivo.open("Promediotxt",ios::out);
    if(archivo.fail()){
        cout<< "No se puede abrir el archivo"<<endl;
    }
    archivo << "=========================="<<endl;
    archivo << "Primera nota: "<<JimenezN1<<endl;
    archivo << "Segunda nota: "<<JimenezN2<<endl;
    archivo << "tercera nota: "<<JimenezN3<<endl;
    archivo << "-------------------------"<<endl;
    archivo << "Promedio:     "<<Promedio<<endl;
    archivo << "=========================="<<endl;
    cout << "+++++++++++++++++++++++++++++++++++++"<<endl;
    cout << "Gracias por utilizar el programa "<<endl;
    cout << "+++++++++++++++++++++++++++++++++++++"<<endl;
    archivo.close();
}
