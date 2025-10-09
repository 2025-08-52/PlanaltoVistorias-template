package Vistoria.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import Vistoria.model.Funcionario;
import Vistoria.model.Agendamento;
import Vistoria.controller.AgendamentoController;
import Vistoria.controller.VistoriaController;
import Vistoria.controller.VeiculoController;
import Vistoria.dao.AgendamentoDAO;

/**
 * Interface principal do vistoriador, com cards e troca dinâmica de painéis.
 */
public class DashboardVistoriador extends JFrame {

    private static final long serialVersionUID = 1L;
    private final Funcionario usuarioAtual;
    private final AgendamentoController agendamentoCtrl;
    private final VistoriaController vistoriaCtrl;
    private final VeiculoController veiculoCtrl;
    private final AgendamentoDAO agendamentoDAO;

    private JPanel painelCards;
    private CardLayout layoutCards;

    private JLabel lblPendentes;
    private JLabel lblConcluidos;
    private JLabel lblCancelados;

    private JTable tableAgendamentos;
    private DefaultTableModel modelTabela;
    private List<Agendamento> agendamentos;

    /** Construtor principal **/
    public DashboardVistoriador(Funcionario funcionario) {
        this.usuarioAtual = funcionario;
        this.agendamentoCtrl = new AgendamentoController();
        this.vistoriaCtrl = new VistoriaController();
        this.veiculoCtrl = new VeiculoController();
        this.agendamentoDAO = new AgendamentoDAO();

        configurarJanela();
        inicializarLayout();
        atualizarCards();

        setVisible(true);
    }

    /** Configuração da janela **/
    private void configurarJanela() {
        setTitle("Painel do Vistoriador - DF Vistoria");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    /** Inicializa os painéis e menu **/
    private void inicializarLayout() {
        JPanel menuLateral = criarMenuLateral();

        layoutCards = new CardLayout();
        painelCards = new JPanel(layoutCards);
        painelCards.setBorder(new EmptyBorder(30, 30, 30, 30));
        painelCards.setBackground(new Color(245, 245, 245));

        painelCards.add(criarPainelResumo(), "Resumo");
        painelCards.add(criarPainelAgendamentos(), "Agendamentos");
        painelCards.add(criarPainelRelatorio(), "Relatorio");

        add(menuLateral, BorderLayout.WEST);
        add(painelCards, BorderLayout.CENTER);
    }

    /** Menu lateral **/
    private JPanel criarMenuLateral() {
        JPanel menu = new JPanel();
        menu.setBackground(new Color(25, 118, 210));
        menu.setPreferredSize(new Dimension(220, 0));
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        menu.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("DF Vistoria", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setForeground(Color.WHITE);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnResumo = criarBotaoMenu("Dashboard");
        JButton btnAgend = criarBotaoMenu("Agendamentos");
        JButton btnRelat = criarBotaoMenu("Relatórios");
        JButton btnSair = criarBotaoMenu("Sair");

        btnResumo.addActionListener(e -> layoutCards.show(painelCards, "Resumo"));
        btnAgend.addActionListener(e -> {
            carregarAgendamentos();
            layoutCards.show(painelCards, "Agendamentos");
        });
        btnRelat.addActionListener(e -> layoutCards.show(painelCards, "Relatorio"));
        btnSair.addActionListener(e -> {
            dispose();
        });

        menu.add(titulo);
        menu.add(Box.createVerticalStrut(50));
        menu.add(btnResumo);
        menu.add(Box.createVerticalStrut(15));
        menu.add(btnAgend);
        menu.add(Box.createVerticalStrut(15));
        menu.add(btnRelat);
        menu.add(Box.createVerticalGlue());
        menu.add(btnSair);

        return menu;
    }

    /** Criação dos botões do menu **/
    private JButton criarBotaoMenu(String texto) {
        JButton botao = new JButton(texto);
        botao.setAlignmentX(Component.CENTER_ALIGNMENT);
        botao.setMaximumSize(new Dimension(200, 40));
        botao.setBackground(new Color(21, 101, 192));
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Segoe UI", Font.BOLD, 15));
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));

        botao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                botao.setBackground(new Color(30, 136, 229));
            }
            public void mouseExited(java.awt.event.MouseEvent e) {
                botao.setBackground(new Color(21, 101, 192));
            }
        });
        return botao;
    }

    /** Painel de resumo (cards) **/
    private JPanel criarPainelResumo() {
        JPanel painel = new JPanel(new GridLayout(1, 3, 20, 0));
        painel.setBackground(new Color(245, 245, 245));

        lblPendentes = criarCard("Pendentes", new Color(255, 152, 0));
        lblConcluidos = criarCard("Concluídos", new Color(76, 175, 80));
        lblCancelados = criarCard("Cancelados", new Color(244, 67, 54));

        painel.add(lblPendentes.getParent());
        painel.add(lblConcluidos.getParent());
        painel.add(lblCancelados.getParent());

        return painel;
    }

    /** Criação de cada card do resumo **/
    private JLabel criarCard(String titulo, Color corTitulo) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                new EmptyBorder(25, 25, 25, 25)
        ));

        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitulo.setForeground(corTitulo);

        JLabel lblValor = new JLabel("0", SwingConstants.CENTER);
        lblValor.setFont(new Font("Segoe UI", Font.BOLD, 48));
        lblValor.setForeground(new Color(33, 150, 243));

        card.add(lblTitulo, BorderLayout.NORTH);
        card.add(lblValor, BorderLayout.CENTER);

        // retorna o número (para atualizar depois)
        JPanel container = new JPanel(new BorderLayout());
        container.add(card, BorderLayout.CENTER);

        return lblValor;
    }

    /** Painel de agendamentos **/
    private JPanel criarPainelAgendamentos() {
        JPanel painel = new JPanel(new BorderLayout(15, 15));
        painel.setBackground(new Color(245, 245, 245));

        JLabel titulo = new JLabel("Agendamentos Pendentes", SwingConstants.LEFT);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
        painel.add(titulo, BorderLayout.NORTH);

        String[] colunas = {"ID", "Data", "Hora", "Cliente", "Veículo"};
        modelTabela = new DefaultTableModel(colunas, 0) {
            private static final long serialVersionUID = 1L;
            public boolean isCellEditable(int r, int c) { return false; }
        };

        tableAgendamentos = new JTable(modelTabela);
        tableAgendamentos.setRowHeight(30);
        tableAgendamentos.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JScrollPane scroll = new JScrollPane(tableAgendamentos);
        painel.add(scroll, BorderLayout.CENTER);

        JButton btnNovaVistoria = new JButton("Nova Vistoria");
        btnNovaVistoria.setBackground(new Color(66, 133, 244));
        btnNovaVistoria.setForeground(Color.WHITE);
        btnNovaVistoria.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnNovaVistoria.addActionListener(e -> {
            int row = tableAgendamentos.getSelectedRow();
            if (row >= 0) {
                Agendamento ag = agendamentos.get(row);
                abrirFormularioVistoria(ag);
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um agendamento.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        JPanel botoes = new JPanel();
        botoes.setBackground(new Color(245, 245, 245));
        botoes.add(btnNovaVistoria);
        painel.add(botoes, BorderLayout.SOUTH);

        return painel;
    }

    /** Painel de relatório **/
    private JPanel criarPainelRelatorio() {
        JPanel painel = new JPanel();
        painel.setBackground(Color.LIGHT_GRAY);
        painel.add(new JLabel("Relatório de Vistorias (em construção...)"));
        return painel;
    }

    /** Carrega os agendamentos **/
    private void carregarAgendamentos() {
        modelTabela.setRowCount(0);
        agendamentos = new ArrayList<>();
        agendamentos = agendamentoDAO.listarAgendamentosAgendadosComDetalhes();

        for (Agendamento a : agendamentos) {
            modelTabela.addRow(new Object[]{
                    a.getIdAgendamento(),
                    a.getData_agendamento(),
                    a.getHora(),
                    a.getCliente().getNome(),
                    a.getVeiculo().getPlaca()
            });
        }
    }

    /** Abre o formulário de vistoria **/
    private void abrirFormularioVistoria(Agendamento agendamento) {
        JPanel form = new JPanel(new GridLayout(5, 2, 10, 10));

        JTextField resultado = new JTextField();
        JTextArea observacoes = new JTextArea(4, 20);
        observacoes.setLineWrap(true);

        form.add(new JLabel("Resultado:"));
        form.add(resultado);
        form.add(new JLabel("Observações:"));
        form.add(new JScrollPane(observacoes));

        int opc = JOptionPane.showConfirmDialog(this, form, "Registrar Vistoria", JOptionPane.OK_CANCEL_OPTION);
        if (opc == JOptionPane.OK_OPTION) {
            vistoriaCtrl.realizarVistoria(agendamento, usuarioAtual,
                    resultado.getText(), "Pendente", observacoes.getText());
            JOptionPane.showMessageDialog(this, "Vistoria salva!");
            carregarAgendamentos();
            atualizarCards();
        }
    }

    /** Atualiza os valores dos cards **/
    private void atualizarCards() {
        lblPendentes.setText(String.valueOf(agendamentoDAO.contarAgendamentosAgendado()));
        lblConcluidos.setText(String.valueOf(agendamentoDAO.contarAgendamentosConcluido()));
        lblCancelados.setText(String.valueOf(agendamentoDAO.contarAgendamentosCancelado()));
    }

    /** Método principal **/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DashboardVistoriador(new Funcionario()));
    }
}
