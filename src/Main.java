import br.com.zaine.dao.ClienteMapDAO;
import br.com.zaine.dao.IClienteDAO;

import javax.swing.*;

public class Main {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();

        int opcao = Integer.parseInt(JOptionPane.showInputDialog(
                null,
                "Digite 1 para cadastrar, 2 para consultar, 3 para excluir, 4 para alterar, 5 para sair",
                "Opções",
                JOptionPane.INFORMATION_MESSAGE
        ));

        while (!isOpcaoValida(opcao)) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    null,
                    "Opção INVÁLIDA!\nDigite 1 para cadastrar, 2 para consultar, 3 para excluir, 4 para alterar, 5 para sair",
                    "Opções",
                    JOptionPane.INFORMATION_MESSAGE
            ));
        }

        if(opcao == 1){

        } else if(opcao == 2){

        } else if(opcao == 3){

        } else if(opcao == 4){

        } else if(opcao == 5){
            sair();
        }

    }

    private static void sair() {
        System.exit(0);
    }

    private static boolean isOpcaoValida(int opcao) {
        return opcao >= 1 && opcao <= 5;
    }
}