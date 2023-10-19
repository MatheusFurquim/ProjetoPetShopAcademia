import java.util.ArrayList;
import java.util.Scanner;

class Animal {
    private String nome;
    private String especie;
    private String raca;
    private String dataNascimento;
    private String proprietario;

    public Animal(String nome, String especie, String raca, String dataNascimento, String proprietario) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.dataNascimento = dataNascimento;
        this.proprietario = proprietario;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaca() {
        return raca;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getProprietario() {
        return proprietario;
    }
}

class Cachorro extends Animal {
    private String corPelo;

    public Cachorro(String nome, String raca, String dataNascimento, String proprietario, String corPelo) {
        super(nome, "Cachorro", raca, dataNascimento, proprietario);
        this.corPelo = corPelo;
    }

    public String getCorPelo() {
        return corPelo;
    }
}

class Produto {
    private String nome;
    private String categoria;
    private float preco; 
    private int qtEstoque;

    public Produto(String nome, String categoria, float preco, int qtEstoque) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.qtEstoque = qtEstoque;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public float getPreco() {
        return preco;
    }

    public int getQtEstoque() {
        return qtEstoque;
    }

        public void vender(int quantidade) {
        if (quantidade <= this.qtEstoque) {
            this.qtEstoque -= quantidade;
        } else {
            throw new IllegalArgumentException("Quantidade em estoque insuficiente.");
        }
    }
}


abstract class Servico {
    public abstract String descricao();
    public abstract double preco();
}

class Banho extends Servico {
    @Override
    public String descricao() {
        return "Banho para o animal";
    }

    @Override
    public double preco() {
        return 50.0;
    }
}

class Tosa extends Servico {
    @Override
    public String descricao() {
        return "Tosa para o animal";
    }

    @Override
    public double preco() {
        return 70.0;
    }
}

class ConsultaVeterinaria extends Servico {
    @Override
    public String descricao() {
        return "Consulta veterinária para o animal";
    }

    @Override
    public double preco() {
        return 150.0;
    }
}

class Agenda {
    private Animal animal;
    private Servico servico;
    private String data;
    private String horario;

    public Agenda(Animal animal, Servico servico, String data, String horario) {
        this.animal = animal;
        this.servico = servico;
        this.data = data;
        this.horario = horario;
    }

    public void agendar(Animal animal, Servico servico, String data, String horario) {
        this.animal = animal;
        this.servico = servico;
        this.data = data;
        this.horario = horario;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Servico getServico() {
        return servico;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }
}


class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Animal> animais = new ArrayList<Animal>();
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        ArrayList<Servico> servicos = new ArrayList<Servico>();
        ArrayList<Agenda> agendamentos = new ArrayList<Agenda>();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastro de animais");
            System.out.println("2. Listar cachorros");
            System.out.println("3. Cadastro de Produtos");
            System.out.println("4. Listar Produtos");
            System.out.println("5. Cadastrar Servico");
            System.out.println("6. Listar de serviços cadastrados");
            System.out.println("7. Agendar Servico");
            System.out.println("8. Registrar Venda de Produto");
            System.out.println("9. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer

            switch (opcao) {
                case 1:
                    // Código para cadastro de cachorros
                    System.out.println("Digite o nome do cachorro:");
                    String nome = scanner.nextLine();

                    System.out.println("Digite a raça do cachorro:");
                    String raca = scanner.nextLine();

                    System.out.println("Digite a data de nascimento do cachorro:");
                    String dataNascimento = scanner.nextLine();

                    System.out.println("Digite o nome do proprietário do cachorro:");
                    String proprietario = scanner.nextLine();

                    System.out.println("Digite a cor do pelo do cachorro:");
                    String corPelo = scanner.nextLine();

                    Cachorro cachorro = new Cachorro(nome, raca, dataNascimento, proprietario, corPelo);
                    animais.add(cachorro);

                    System.out.println("Cachorro cadastrado com sucesso!");
                    break;
                case 2:
                    // Código para listar cachorros
                    System.out.println("Lista de cachorros cadastrados:");
                    for (Animal animal : animais) {
                        if (animal.getEspecie().equals("Cachorro")) {
                            System.out.println("Nome: " + animal.getNome());
                            System.out.println("Raça: " + animal.getRaca());
                            System.out.println("Data de Nascimento: " + animal.getDataNascimento());
                            System.out.println("Proprietário: " + animal.getProprietario());
                            System.out.println("Cor do Pelo: " + ((Cachorro) animal).getCorPelo());
                            System.out.println();
                        }
                    }
                    break;
                case 3:
                    // Código para cadastro de produtos
                    System.out.println("Digite o nome do produto:");
                    nome = scanner.nextLine();

                    System.out.println("Digite a categoria do produto:");
                    String categoria = scanner.nextLine();

                    System.out.println("Digite o preço do produto:");
                    float preco = scanner.nextFloat();
                    scanner.nextLine(); // limpa o buffer

                    System.out.println("Digite a quantidade em estoque do produto:");
                    int qtEstoque = scanner.nextInt();
                    scanner.nextLine(); // limpa o buffer

                    Produto produto = new Produto(nome, categoria, preco, qtEstoque);
                    produtos.add(produto);

                    System.out.println("Produto cadastrado com sucesso!");
                    break;
                case 4:
                    // Código para listar produtos
                    System.out.println("Lista de produtos cadastrados:");
                    for (Produto produtoListado : produtos) {
                        System.out.println("Nome: " + produtoListado.getNome());
                        System.out.println("Categoria: " + produtoListado.getCategoria());
                        System.out.println("Preco: " + produtoListado.getPreco());
                        System.out.println("Quantidade em Estoque: " + produtoListado.getQtEstoque());                        
                        System.out.println();
                    }
                    break;
                case 5:
                System.out.println("Escolha um serviço:");
                System.out.println("1. Banho");
                System.out.println("2. Tosa");
                System.out.println("3. Consulta Veterinaria");

                int opcaoServico = scanner.nextInt();
                scanner.nextLine(); // limpa o buffer

                switch (opcaoServico) {
                    case 1:
                        servicos.add(new Banho());
                        System.out.println("Serviço de Banho cadastrado com sucesso!");
                        break;
                    case 2:
                        servicos.add(new Tosa());
                        System.out.println("Serviço de Tosa cadastrado com sucesso!");
                        break;
                    case 3:
                        servicos.add(new ConsultaVeterinaria());
                        System.out.println("Serviço de Consulta Veterinária cadastrado com sucesso!");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
                    break;
                case 6:
                    System.out.println("Lista de serviços cadastrados:");
                    for (Servico servico : servicos) {
                        System.out.println("Descrição: " + servico.descricao());
                        System.out.println("Preço: " + servico.preco());
                        System.out.println();
                    }
                    
                    break;
                case 7:
                System.out.println("Agendar Servico");

                System.out.println("Escolha um animal para o agendamento:");
                for (int i = 0; i < animais.size(); i++) {
                    System.out.println((i+1) + ". " + animais.get(i).getNome());
                }
                int escolhaAnimal = scanner.nextInt();
                scanner.nextLine(); // limpa o buffer

                System.out.println("Escolha um serviço para o agendamento:");
                for (int i = 0; i < servicos.size(); i++) {
                    System.out.println((i+1) + ". " + servicos.get(i).descricao());
                }
                int escolhaServico = scanner.nextInt();
                scanner.nextLine(); // limpa o buffer

                System.out.println("Digite a data do agendamento (formato DD/MM/AAAA):");
                String dataAgendamento = scanner.nextLine();

                System.out.println("Digite o horário do agendamento (formato HH:mm):");
                String horarioAgendamento = scanner.nextLine();

                boolean horarioOcupado = false;
                for (Agenda agendamento : agendamentos) {
                    if (agendamento.getData().equals(dataAgendamento) && agendamento.getHorario().equals(horarioAgendamento)) {
                        horarioOcupado = true;
                        break;
                    }
                }

                if (horarioOcupado) {
                    System.out.println("O horário escolhido já está ocupado. Por favor, escolha outro horário.");
                } else {
                    Agenda novoAgendamento = new Agenda(
                        animais.get(escolhaAnimal - 1),
                        servicos.get(escolhaServico - 1),
                        dataAgendamento,
                        horarioAgendamento
                    );
                    agendamentos.add(novoAgendamento);
                    System.out.println("Serviço agendado com sucesso!");
                }
 
                    
                    break;
                case 8:
                System.out.println("Registrar Venda de Produto");

                System.out.println("Escolha um produto para a venda:");
                for (int i = 0; i < produtos.size(); i++) {
                    System.out.println((i+1) + ". " + produtos.get(i).getNome());
                }
                int escolhaProduto = scanner.nextInt();
                scanner.nextLine(); // limpa o buffer

                System.out.println("Digite a quantidade a ser vendida:");
                int quantidade = scanner.nextInt();
                scanner.nextLine(); // limpa o buffer

                try {
                    produtos.get(escolhaProduto - 1).vender(quantidade);
                    System.out.println("Venda registrada com sucesso!");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;

                case 9:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
