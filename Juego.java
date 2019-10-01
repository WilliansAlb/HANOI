import java.sql.SQLOutput;
import java.util.Scanner;

public class Juego {
    private String nombreJ = "";
    private int numeroF = 0, colum1 = 0, colum2 = 0, colum3 = 0, mov = 0;
    private Scanner escaneando;
    private Ficha[][] fichas;
    Juego(){

    }
    public void bienvenidaJuego(int estado){
        if (estado==0){
            escaneando = new Scanner(System.in);
            for (int i = 0; i<7; i++){
                System.out.println("    ");
            }
        }
        System.out.println("¿Con cuantas filas jugaras?");
        numeroF = escaneando.nextInt();
        setColum1(numeroF);
        for (int i = 0; i<1; i++){
            System.out.println("    ");
        }
        escaneando = new Scanner(System.in);
        System.out.println("¿Son correctos los datos? (s)Si (n)No \nFilas: "+getNumeroF());
        dibujarColumnas();
        String eleccion = escaneando.nextLine();
        if (eleccion.equalsIgnoreCase("s")){
            System.out.println("Empezando a realizar los movimientos");
        } else {
            for (int i = 0; i<1; i++){
                System.out.println("    ");
            }
            System.out.println("Entonces...");
            bienvenidaJuego(1);
        }
        /**while (getColum3()!=getNumeroF()){
            /**if(mov==0){
                escaneando = new Scanner(System.in);
                System.out.println("¿Hacia donde moverás la primera ficha?");
                int mover = escaneando.nextInt();
                verificarMov(1, mover);
            } else{
                escaneando = new Scanner(System.in);
                System.out.println("¿Dé que columna?");
                int mover2 = escaneando.nextInt();
                escaneando = new Scanner(System.in);
                System.out.println("¿Hacia donde moverás la ficha?");
                int hacia2 = escaneando.nextInt();
                verificarMov(mover2,hacia2);
            }

        }**/
        torresHanoi(numeroF,1,2,3);

        System.out.println("Lo lograste, con "+mov+" movimientos");
    }

    public void verificarMov(int colum, int hacia){
        colum = colum - 1;
        int numE;
        int numH;
        for (int i = 0; i < 3; i++){
            System.out.println(" ");
        }
        System.out.println("MOVIMIENTO-"+(mov+1)+"-");
        Ficha temp = new Ficha();
        switch (colum){
            case 0:
            {
                numE = fichas[fichas.length-(getColum1())][0].getNumFicha();
                if (2==hacia){
                    numH = fichas[fichas.length-(getColum2())-1][hacia-1].getNumFicha();
                    if (getColum2()==0){
                        temp.setNumFicha(numE);
                        temp.setFichaO(fichas[fichas.length-(getColum1())][0].getFichaO());
                        fichas[fichas.length-(getColum1())][0].setNumFicha(0);
                        fichas[fichas.length-(getColum1())][0].setFichaO(fichas[fichas.length-(getColum2())-1][hacia-1].getFichaO());
                        fichas[fichas.length-(getColum2())-1][hacia-1] = temp;
                        int cambio = getColum1()-1;
                        setColum1(cambio);
                        int cambio2 = getColum2()+1;
                        setColum2(cambio2);
                    } else {
                        if (numE<numH){
                            temp.setNumFicha(numE);
                            temp.setFichaO(fichas[fichas.length-(getColum1())][0].getFichaO());
                            fichas[fichas.length-(getColum1())][0].setNumFicha(0);
                            fichas[fichas.length-(getColum1())][0].setFichaO(fichas[fichas.length-(getColum2()-1)][hacia-1].getFichaO());
                            fichas[fichas.length-(getColum2())-1][hacia-1] = temp;
                            int cambio = getColum1()-1;
                            setColum1(cambio);
                            int cambio2 = getColum2()+1;
                            setColum2(cambio2);
                        } else {
                            if (numH==0){
                                temp.setNumFicha(numE);
                                temp.setFichaO(fichas[fichas.length-(getColum1())][0].getFichaO());
                                fichas[fichas.length-(getColum1())][0].setNumFicha(0);
                                fichas[fichas.length-(getColum1())][0].setFichaO(fichas[fichas.length-(getColum2())-1][hacia-1].getFichaO());
                                fichas[fichas.length-(getColum2())-1][hacia-1] = temp;
                                int cambio = getColum1()-1;
                                setColum1(cambio);
                                int cambio2 = getColum2()+1;
                                setColum2(cambio2);
                            }
                        }
                    }
                }
                if (3==hacia) {
                    numH = fichas[fichas.length-(getColum3())-1][hacia-1].getNumFicha();
                    if (getColum3()==0){
                        temp.setNumFicha(numE);
                        temp.setFichaO(fichas[fichas.length-(getColum1())][0].getFichaO());
                        fichas[fichas.length-(getColum1())][0].setNumFicha(0);
                        fichas[fichas.length-(getColum1())][0].setFichaO(fichas[fichas.length-(getColum3())-1][hacia-1].getFichaO());
                        fichas[fichas.length-(getColum3())-1][hacia-1] = temp;
                        int cambio = getColum1()-1;
                        setColum1(cambio);
                        int cambio2 = getColum3()+1;
                        setColum3(cambio2);
                    } else {
                        if (numE<numH){
                            temp.setNumFicha(numE);
                            temp.setFichaO(fichas[fichas.length-(getColum1())][0].getFichaO());
                            fichas[fichas.length-(getColum1())][0].setNumFicha(0);
                            fichas[fichas.length-(getColum1())][0].setFichaO(fichas[fichas.length-(getColum3())-1][hacia-1].getFichaO());
                            fichas[fichas.length-(getColum3())-1][hacia-1] = temp;
                            int cambio = getColum1()-1;
                            setColum1(cambio);
                            int cambio2 = getColum3()+1;
                            setColum3(cambio2);
                        } else {
                            if (numH==0){
                                temp.setNumFicha(numE);
                                temp.setFichaO(fichas[fichas.length-(getColum1())][0].getFichaO());
                                fichas[fichas.length-(getColum1())][0].setNumFicha(0);
                                fichas[fichas.length-(getColum1())][0].setFichaO(fichas[fichas.length-(getColum3())-1][hacia-1].getFichaO());
                                fichas[fichas.length-(getColum3())-1][hacia-1] = temp;
                                int cambio = getColum1()-1;
                                setColum1(cambio);
                                int cambio2 = getColum3()+1;
                                setColum3(cambio2);
                            }
                        }
                    }
                }
                mov++;
                break;
            }
            case 1: {
                numE = fichas[fichas.length - (getColum2())-1][colum].getNumFicha();
                if (3 == hacia) {
                    numH = fichas[fichas.length - (getColum3()) - 1][hacia - 1].getNumFicha();
                    if (getColum3() == 0) {
                        temp.setNumFicha(numE);
                        temp.setFichaO(fichas[fichas.length - (getColum2())][colum].getFichaO());
                        fichas[fichas.length - (getColum2())][colum].setNumFicha(0);
                        fichas[fichas.length - (getColum2())][colum].setFichaO(fichas[fichas.length - (getColum3())-1][hacia - 1].getFichaO());
                        fichas[fichas.length - (getColum3()) - 1][hacia - 1] = temp;
                        int cambio = getColum2() - 1;
                        setColum2(cambio);
                        int cambio2 = getColum3() + 1;
                        setColum3(cambio2);
                    } else {
                        if (numE < numH) {
                            temp.setNumFicha(numE);
                            temp.setFichaO(fichas[fichas.length - (getColum2())-1][0].getFichaO());
                            fichas[fichas.length - (getColum2())][colum].setNumFicha(0);
                            fichas[fichas.length - (getColum2())][colum].setFichaO(fichas[fichas.length - (getColum3())-1][hacia - 1].getFichaO());
                            fichas[fichas.length - (getColum3()) - 1][hacia - 1] = temp;
                            int cambio = getColum2() - 1;
                            setColum2(cambio);
                            int cambio2 = getColum3() + 1;
                            setColum3(cambio2);
                        } else {
                            if (numH==0){
                                temp.setNumFicha(numE);
                                temp.setFichaO(fichas[fichas.length - (getColum2())][colum].getFichaO());
                                fichas[fichas.length - (getColum2())][colum].setNumFicha(0);
                                fichas[fichas.length - (getColum2())][colum].setFichaO(fichas[fichas.length - (getColum3())-1][hacia - 1].getFichaO());
                                fichas[fichas.length - (getColum3()) - 1][hacia - 1] = temp;
                                int cambio = getColum2() - 1;
                                setColum2(cambio);
                                int cambio2 = getColum3() + 1;
                                setColum3(cambio2);
                            }
                        }
                    }
                }
                if (1 == hacia) {
                    numH = fichas[fichas.length - (getColum1())-1][hacia - 1].getNumFicha();
                    if (getColum1() == 0) {
                        temp.setNumFicha(numE);
                        temp.setFichaO(fichas[fichas.length - (getColum2())][colum].getFichaO());
                        fichas[fichas.length - (getColum2())][colum].setNumFicha(0);
                        fichas[fichas.length - (getColum2())][colum].setFichaO(fichas[fichas.length - (getColum1())-1][hacia - 1].getFichaO());
                        fichas[fichas.length - (getColum1()) - 1][hacia - 1] = temp;
                        int cambio = getColum2() - 1;
                        setColum2(cambio);
                        int cambio2 = getColum1() + 1;
                        setColum1(cambio2);
                    } else {
                        if (numE < numH) {
                            temp.setNumFicha(numE);
                            temp.setFichaO(fichas[fichas.length - (getColum2())][colum].getFichaO());
                            fichas[fichas.length - (getColum2())][colum].setNumFicha(0);
                            fichas[fichas.length - (getColum2())][colum].setFichaO(fichas[fichas.length - (getColum1())-1][hacia - 1].getFichaO());
                            fichas[fichas.length - (getColum1()) - 1][hacia - 1] = temp;
                            int cambio = getColum2() - 1;
                            setColum2(cambio);
                            int cambio2 = getColum1() + 1;
                            setColum1(cambio2);
                        } else {
                            if (numH==0)
                            {
                                temp.setNumFicha(numE);
                                temp.setFichaO(fichas[fichas.length - (getColum2())][colum].getFichaO());
                                fichas[fichas.length - (getColum2())][colum].setNumFicha(0);
                                fichas[fichas.length - (getColum2())][colum].setFichaO(fichas[fichas.length - (getColum1())-1][hacia - 1].getFichaO());
                                fichas[fichas.length - (getColum1()) - 1][hacia - 1] = temp;
                                int cambio = getColum2() - 1;
                                setColum2(cambio);
                                int cambio2 = getColum1() + 1;
                                setColum1(cambio2);
                            }
                        }
                    }
                }
                mov++;
                break;
            }
            case 2: {
                numE = fichas[fichas.length - (getColum3())][colum].getNumFicha();
                if (2 == hacia) {
                    numH = fichas[fichas.length - (getColum2())-1][hacia - 1].getNumFicha();
                    if (getColum2() == 0) {
                        temp.setNumFicha(numE);
                        temp.setFichaO(fichas[fichas.length - (getColum3())][colum].getFichaO());
                        fichas[fichas.length - (getColum3())][colum].setNumFicha(0);
                        fichas[fichas.length - (getColum3())][colum].setFichaO(fichas[fichas.length - (getColum2())-1][hacia - 1].getFichaO());
                        fichas[fichas.length - (getColum2()) - 1][hacia - 1] = temp;
                        int cambio = getColum3() - 1;
                        setColum3(cambio);
                        int cambio2 = getColum2() + 1;
                        setColum2(cambio2);
                    } else {
                        if (numE < numH) {
                            temp.setNumFicha(numE);
                            temp.setFichaO(fichas[fichas.length - (getColum3())][colum].getFichaO());
                            fichas[fichas.length - (getColum3())][colum].setNumFicha(0);
                            fichas[fichas.length - (getColum3())][colum].setFichaO(fichas[fichas.length - (getColum2())-1][hacia - 1].getFichaO());
                            fichas[fichas.length - (getColum2())][hacia - 1] = temp;
                            int cambio = getColum3() - 1;
                            setColum3(cambio);
                            int cambio2 = getColum2() + 1;
                            setColum2(cambio2);
                        } else {
                            if (numH==0){
                                temp.setNumFicha(numE);
                                temp.setFichaO(fichas[fichas.length - (getColum3())][colum].getFichaO());
                                fichas[fichas.length - (getColum3())][colum].setNumFicha(0);
                                fichas[fichas.length - (getColum3())][colum].setFichaO(fichas[fichas.length - (getColum2())-1][hacia - 1].getFichaO());
                                fichas[fichas.length - (getColum2())-1][hacia - 1] = temp;
                                int cambio = getColum3() - 1;
                                setColum3(cambio);
                                int cambio2 = getColum2() + 1;
                                setColum2(cambio2);
                            }
                        }
                    }
                }
                if (1 == hacia) {
                    numH = fichas[fichas.length - (getColum1())-1][hacia - 1].getNumFicha();
                    if (getColum1() == 0) {
                        temp.setNumFicha(numE);
                        temp.setFichaO(fichas[fichas.length - (getColum3())][colum].getFichaO());
                        fichas[fichas.length - (getColum3())][colum].setNumFicha(0);
                        fichas[fichas.length - (getColum3())][colum].setFichaO(fichas[fichas.length - (getColum1())-1][hacia - 1].getFichaO());
                        fichas[fichas.length - (getColum1()) - 1][hacia - 1] = temp;
                        int cambio = getColum3() - 1;
                        setColum3(cambio);
                        int cambio2 = getColum1() + 1;
                        setColum1(cambio2);
                    } else {
                        if (numE < numH) {
                            temp.setNumFicha(numE);
                            temp.setFichaO(fichas[fichas.length - (getColum3())][colum].getFichaO());
                            fichas[fichas.length - (getColum3())][colum].setNumFicha(0);
                            fichas[fichas.length - (getColum3())][colum].setFichaO(fichas[fichas.length - (getColum1())-1][hacia - 1].getFichaO());
                            fichas[fichas.length - (getColum1()) - 1][hacia - 1] = temp;
                            int cambio = getColum3() - 1;
                            setColum3(cambio);
                            int cambio2 = getColum1() + 1;
                            setColum1(cambio2);
                        } else {
                            if (numH==0){
                                temp.setNumFicha(numE);
                                temp.setFichaO(fichas[fichas.length - (getColum3())][colum].getFichaO());
                                fichas[fichas.length - (getColum3())][colum].setNumFicha(0);
                                fichas[fichas.length - (getColum3())][colum].setFichaO(fichas[fichas.length - (getColum1())-1][hacia - 1].getFichaO());
                                fichas[fichas.length - (getColum1()) - 1][hacia - 1] = temp;
                                int cambio = getColum3() - 1;
                                setColum3(cambio);
                                int cambio2 = getColum1() + 1;
                                setColum1(cambio2);
                            }
                        }
                    }
                }
                mov++;
                break;
            }
            default:
                System.out.println("No");
        }
        for (int p = 0; p<getNumeroF(); p++){
            for (int q = 0; q<3; q++){
                System.out.print(fichas[p][q].getFichaO()+" | ");
            }
            System.out.println(" ");
        }
        try{
            Thread.sleep(2500);
        }catch(InterruptedException e){

        }
    }

    public void dibujarColumnas(){
        fichas = new Ficha[getNumeroF()][3];
        for (int p = 0; p<getNumeroF(); p++){
            for (int q = 0; q<3; q++){
                fichas[p][q] = new Ficha();
                String fichas0 = "";
                for (int i = 0; i < getNumeroF(); i++){
                     fichas0 = fichas[p][q].getFichaO()+"-";
                     fichas[p][q].setFichaO(fichas0);
                }
            }
        }
        int conteo = 1;
        for (int i = 0; i<getNumeroF(); i++){
            fichas[i][0].setFichaO(" ");
            for (int u = 0; u<conteo; u++){
                String fichas1 = fichas[i][0].getFichaO()+"X";
                fichas[i][0].setFichaO(fichas1);
                fichas[i][0].setNumFicha(conteo);
            }
            for (int p = conteo; p<getNumeroF(); p++){
                String fichas2 = fichas[i][0].getFichaO()+"-";
                fichas[i][0].setFichaO(fichas2);
            }
            conteo++;
        }
        for (int p = 0; p<getNumeroF(); p++){
            for (int q = 0; q<3; q++){
                System.out.print(fichas[p][q].getFichaO()+" | ");
            }
            System.out.println(" ");
        }
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){

        }
    }

    public Scanner getEscaneando() {
        return escaneando;
    }

    public String getNombreJ() {
        return nombreJ;
    }

    public int getNumeroF() {
        return numeroF;
    }

    public int getColum1() {
        return colum1;
    }

    public void setColum1(int colum1) {
        this.colum1 = colum1;
    }

    public int getColum2() {
        return colum2;
    }

    public void setColum2(int colum2) {
        this.colum2 = colum2;
    }

    public int getColum3() {
        return colum3;
    }

    public void setColum3(int colum3) {
        this.colum3 = colum3;
    }

    public void torresHanoi(int discos, int torre1, int torre2, int torre3){
        if (discos==1){
            verificarMov(torre1,torre3);
        } else {
            torresHanoi(discos-1,torre1,torre3,torre2);
            verificarMov(torre1,torre3);
            torresHanoi(discos-1,torre2,torre1,torre3);
        }

    }
}
