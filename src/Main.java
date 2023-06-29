import br.com.zaine.dao.ClienteMapDAO;
import br.com.zaine.dao.IClienteDAO;
import br.com.zaine.domain.Cliente;

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

        trataOpcoesInvalidas(opcao);

        while (isOpcaoValida(opcao)) {
            if(opcao == 1){
                String dados = JOptionPane.showInputDialog(
                        null,
                        "Digite os dados separados por virgula!\nExemplo: Nome,CPF,Telefone,Endereco,Numero,Cidade,Estado",
                        "Cadastro",
                        JOptionPane.INFORMATION_MESSAGE
                );
                cadastrar(dados);
            } else if(opcao == 2){
                String cpf = JOptionPane.showInputDialog(
                        null,
                        "Digite o CPF do cliente que deseja consultar:",
                        "Consultar cliente",
                        JOptionPane.INFORMATION_MESSAGE
                );
                consultar(cpf);
            } else if(opcao == 3){
                String dados = JOptionPane.showInputDialog(
                        null,
                        "Digite o CPF do cliente que deseja excluir:",
                        "Excluir cliente",
                        JOptionPane.INFORMATION_MESSAGE
                );
                //excluir(dados);
            } else if(opcao == 4){
                String dados = JOptionPane.showInputDialog(
                        null,
                        "Digite os dados separados por virgula!\nExemplo: Nome,CPF,Telefone,Endereco,Numero,Cidade,Estado",
                        "Atualizar",
                        JOptionPane.INFORMATION_MESSAGE
                );
                //atualizar(dados);
            } else if(opcao == 5){
                JOptionPane.showMessageDialog(
                        null,
                        "Até logo!",
                        "Sair",
                        JOptionPane.INFORMATION_MESSAGE
                );
                System.exit(0);
            }

            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    null,
                    "Digite 1 para cadastrar, 2 para consultar, 3 para excluir, 4 para alterar, 5 para sair",
                    "Opções",
                    JOptionPane.INFORMATION_MESSAGE
            ));

            trataOpcoesInvalidas(opcao);
        }

    }

    private static void consultar(String cpf) {
        String cpfSemEspacos = cpf.trim();
        Long cpfLong = Long.valueOf(cpfSemEspacos);

        Cliente clienteConsultado = iClienteDAO.consultar(cpfLong);
        if(clienteConsultado != null){
            JOptionPane.showMessageDialog(
                    null,
                    "Cliente encontrado: \n" + clienteConsultado.toString(),
                    "Resultado Consulta",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Cliente não encontrado",
                    "Resultado Consulta",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        Cliente cliente = new Cliente(
                dadosSeparados[0],
                dadosSeparados[1],
                dadosSeparados[2],
                dadosSeparados[3],
                dadosSeparados[4],
                dadosSeparados[5],
                dadosSeparados[6]
        );

        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);

        if(isCadastrado) {
            JOptionPane.showMessageDialog(
                    null,
                    "Cliente cadastrado com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Cliente já está cadastrado!",
                    "Erro",
                    JOptionPane.INFORMATION_MESSAGE
                    );
        }
    }

    private static boolean isOpcaoValida(int opcao) {
        return opcao >= 1 && opcao <= 5;
    }

    private static void trataOpcoesInvalidas(int opcao) {
        while (!isOpcaoValida(opcao)) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    null,
                    "Opção INVÁLIDA!\nDigite 1 para cadastrar, 2 para consultar, 3 para excluir, 4 para alterar, 5 para sair",
                    "Opções",
                    JOptionPane.INFORMATION_MESSAGE
            ));
        }
    }
}