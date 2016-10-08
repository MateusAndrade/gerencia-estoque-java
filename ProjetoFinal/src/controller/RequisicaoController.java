package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Funcionario;
import model.ItensRequisicao;
import model.Produtos;
import model.Requisicao;
import persistence.ItensRequisicaoDao;
import persistence.ProdutosDao;
import persistence.RequisicaoDao;
import view.TelaRequisicao;

public class RequisicaoController implements ActionListener {

	private JTextField tfCodigoRequisicao;
	private JTextField tfFuncionario;
	private JTextField tfDataEmissao;
	private JComboBox<Produtos> comboBoxMaterial;
	private JTable tableMaterias;
	private JSpinner spinnerQuantidade;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JButton btnIncluir;
	private JButton btnRemover;
	private Funcionario funcionarioLogado;
	private TelaRequisicao tela;

	private int quantidade;
	private DefaultTableModel model;

	List<ItensRequisicao> listaItensRequisicao = new ArrayList<ItensRequisicao>();

	public RequisicaoController() {
	}

	public RequisicaoController(JTextField tfCodigoRequisicao, JTextField tfFuncionario, JTextField tfDataEmissao,
			JComboBox<Produtos> comboBoxMaterial, JTable tableMaterias, JSpinner spinnerQuantidade, JButton btnSalvar,
			JButton btnCancelar, JButton btnIncluir, JButton btnRemover, Funcionario funcionarioLogado,
			DefaultTableModel model, TelaRequisicao tela) {
		this.tfCodigoRequisicao = tfCodigoRequisicao;
		this.tfFuncionario = tfFuncionario;
		this.tfDataEmissao = tfDataEmissao;
		this.comboBoxMaterial = comboBoxMaterial;
		this.tableMaterias = tableMaterias;
		this.spinnerQuantidade = spinnerQuantidade;
		this.btnSalvar = btnSalvar;
		this.btnCancelar = btnCancelar;
		this.btnIncluir = btnIncluir;
		this.btnRemover = btnRemover;
		this.funcionarioLogado = funcionarioLogado;
		this.model = model;
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {

		try {
			RequisicaoDao rDao = new RequisicaoDao();
			ProdutosDao pDao = new ProdutosDao();

			tfCodigoRequisicao.setText(String.valueOf(rDao.gerarCodigo()));
			tfFuncionario.setText(funcionarioLogado.getNomeFuncionario());
			tfDataEmissao.setText(getDateTime());

			final Requisicao requisicao = new Requisicao();
			requisicao.setCodigoRequiscao(Integer.parseInt(tfCodigoRequisicao.getText()));

			List<Produtos> listaProdutos = pDao.consultaProdutos();
			if (comboBoxMaterial.getItemCount() > 0) {
				comboBoxMaterial.removeAllItems();
			}
			if (listaProdutos != null) {
				for (Produtos p : listaProdutos) {
					comboBoxMaterial.addItem(p);
				}
			}

			btnIncluir.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Produtos p = new Produtos();

					p = (Produtos) comboBoxMaterial.getSelectedItem();
					quantidade = (int) spinnerQuantidade.getValue();

					ItensRequisicao itensRequisicao = new ItensRequisicao();
					itensRequisicao.setProduto(p);
					itensRequisicao.setQuantidadeSolicitado(quantidade);
					itensRequisicao.setRequisicao(requisicao);
					
					if( p.getQtdeProduto() < quantidade){
						JOptionPane.showMessageDialog(null,
								"Quantidade insuficiente em estoque do produto " + p.getNomeProduto());
						
					}else {
					
					TabelaItensProdutos tabelaItensProdutos = new TabelaItensProdutos(model, itensRequisicao);
					tabelaItensProdutos.preencheTabela();
					listaItensRequisicao.add(itensRequisicao);
					spinnerQuantidade.setValue(0);
					}
				}

			});

			btnRemover.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent event) {

					int linha = tableMaterias.rowAtPoint(event.getPoint());
					TabelaItensProdutos tabelaItensProdutos = new TabelaItensProdutos(model);
					tabelaItensProdutos.removeLinha(linha);

					listaItensRequisicao.remove(linha);
				}

			});

			if (e.getSource() == btnSalvar) {

				requisicao.setFuncionario(funcionarioLogado);
				Date date = new Date();
				requisicao.setDataRequisicao(date);
				requisicao.setIntensRequisicao(listaItensRequisicao);
				rDao.adicionaRequisicao(requisicao);


				ItensRequisicaoDao itensRequisicaoDao = new ItensRequisicaoDao();
				for (ItensRequisicao itensRequsicao : listaItensRequisicao) {
					int quantidadeCalculada;
					itensRequisicaoDao.adiciona(itensRequsicao);
					Produtos p2 = new Produtos();
					p2 = pDao.consultaProdutoTable(itensRequsicao.getProduto());
					quantidadeCalculada = p2.getQtdeProduto() - itensRequsicao.getQuantidadeSolicitado();
					pDao.alteraQuantiade(itensRequsicao.getProduto(), quantidadeCalculada);
				}

				JOptionPane.showMessageDialog(null, "Requisicao adicionado com sucesso");
				tela.setVisible(false);
				tela.dispose();

			} else if (e.getSource() == btnCancelar) {
				tela.setVisible(false);
				tela.dispose();
			}

		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}

}
