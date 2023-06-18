package paquete;
import java.util.ArrayList;

public class Listado {
    ArrayList<Asesoria> lista = new ArrayList<>();

    public Listado() {
    }

    public Listado(ArrayList<Asesoria> lista) {
        this.lista = lista;
    }

    public ArrayList<Asesoria> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Asesoria> lista) {
        this.lista = lista;
    }

    public void AddUsuario(Asesoria usuario){
        lista.add(usuario);
    }

    public void ListarUsuarios(){
        for(Asesoria usuario : lista){
            System.out.println(usuario.analizarUsuario());
        }
    }
}
