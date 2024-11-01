
package jimenezdiego_java;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;

public class JimenezDiego_Java {
    
    static float JimenezN1, JimenezN2, JimenezN3, Promedio;
    static final String FILE_PATH = "Notas.CSV";
    static final String FILE_PATH_JSON = "Notas.JSON";
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Menu_P(scanner);
        scanner.close();
        // TODO code application logic here
    }
    static void Menu_P (Scanner scanner){
        int op;
        System.out.println("1. Ingreso de Notas");
        System.out.println("2. Promedio");
        System.out.println("3. Salir");
        System.out.print("Ingrese una opcion: ");
        op=scanner.nextInt();
        switch(op){
            case 1:
                Jimenez_Notas (scanner);
                Menu_P(scanner);
                break;
            case 2:
                Jimenez_Promedio(scanner, JimenezN1,JimenezN2,JimenezN3);
                Menu_P(scanner);
                break;
            case 3:
                Menu_Salir(scanner);
                break;
            default:
                System.out.print("Opcion incorecta");
                break;
        }
    }
    static void Jimenez_Notas (Scanner scanner){
    System.out.print("Cual es su primer nota (0-20): ");
    JimenezN1=scanner.nextFloat();
    while (JimenezN1<0 || JimenezN1>20){
        System.out.print("Se a pasado de los limites establecidos. Ingrese otra nota: ");
        JimenezN1= scanner.nextFloat();
    }
    
    System.out.print("Cual es su segunda nota (0-20): ");
    JimenezN2=scanner.nextFloat();
    while (JimenezN2<0 || JimenezN2>20){
        System.out.print("Se a pasado de los limites establecidos. Ingrese otra nota: ");
        JimenezN2= scanner.nextFloat();
    }
    
    System.out.print("Cual es su tercer nota (0-20): ");
    JimenezN3=scanner.nextFloat();
    while (JimenezN3<0 || JimenezN3>20){
        System.out.print("Se a pasado de los limites establecidos. Ingrese otra nota: ");
        JimenezN3= scanner.nextFloat();
    }
    }
    
    static void Jimenez_Promedio(Scanner scanner, float JimN1,float JimN2,float JimN3){
        Promedio= (JimN1+JimN2+JimN3)/3;
        System.out.println("==========================");
        System.out.println("Primera nota: "+ JimN1);
        System.out.println("Segunda nota: "+ JimN2);
        System.out.println("Tercera nota: "+ JimN3);
        System.out.println("----------------------");
        System.out.println("Promedio:     "+ Promedio);
        System.out.println("==========================");
    }
    static void Menu_Salir(Scanner scanner){
    char op;
    System.out.print ("Deasea Guardar las notas (s/n)? ");
    op=scanner.next().charAt(0);
    switch(op){
    case 's':
           GuardarCSV_JSON(JimenezN1,JimenezN2,JimenezN3);
           System.out.println("================================");
           System.out.println("GRACIAS POR UTILIZAR EL PROGRAMA");
           System.out.println("================================");
        break;
    case 'n':
           System.out.println("No se a guardado las notas.");
           System.out.println("================================");
           System.out.println("GRACIAS POR UTILIZAR EL PROGRAMA");
           System.out.println("================================");
        break;
    default:
        System.out.println("OPCIÓN INCORRECTA. ESCOJA OTRA.");
        Menu_Salir(scanner);
        break;
    }
    }
    static void GuardarCSV_JSON(float JimN1,float JimN2,float JimN3){
     try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))){
                    writer.write("Primera nota: "+JimN1);
                    writer.write("Segunda nota: "+ JimN2);
                    writer.write("Tercera nota: "+ JimN3);
                    writer.write("Promedio:     "+Promedio );
                    System.out.println("ARCHIVO CSV GUARDADO  "+FILE_PATH);
                }catch(IOException e){
                    e.printStackTrace();
                }
     try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH_JSON))){
                    writer.write("{");
                    writer.write("Primera nota: "+JimN1+ ", Segunda nota: "+ JimN2 +", Tercera nota: "+ JimN3+", Promedio: "+Promedio );
                    writer.write("}");
                    System.out.println("ARCHIVO JSON GUARDADO: "+ FILE_PATH_JSON);
                }catch(IOException e){
                    e.printStackTrace();
                }

    }
    
}
