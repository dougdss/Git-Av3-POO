package br.unifor.poo.view.frames;

import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import br.unifor.poo.modelo.Cardapio;
import br.unifor.poo.view.components.IDialogT;
import br.unifor.poo.view.util.Misc;

@SuppressWarnings("serial")
public class DialogCardapio extends IDialogT<Cardapio> {
	public DialogCardapio(Cardapio _item, Frame parentFrame, String title, int width, int height) {
		super(_item, parentFrame, title, width, height);
	}
	public DialogCardapio(Cardapio _item, JDialog parentFrame, String title, int width, int height) {
		super(_item, parentFrame, title, width, height);
	}
	@Override
	protected void events() {
		super.events();
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent mouseEvent) {
				if (mouseEvent.getClickCount() == 1 && tabela.getSelectedRow() != -1) {
					Cardapio c = modelo.getValueAtRow(tabela.getSelectedRow());

					crudPanel.txtFiels.get("id").setText(c.getId()+"");
					crudPanel.txtFiels.get("nome").setText(c.getNome()+"");
					crudPanel.txtFiels.get("preco").setText(c.getPreco()+"");
					crudPanel.txtFiels.get("qtd").setText(c.getQtd()+"");
				}
			}
		});
	}
	@Override
	protected void newItem() {
		try {
			Long code = Misc.code++;
			String nome = crudPanel.txtFiels.get("nome").getText();
			Double preco = Double.parseDouble(crudPanel.txtFiels.get("preco").getText());
			Integer qtd = Integer.parseInt(crudPanel.txtFiels.get("qtd").getText());
			Cardapio item = new Cardapio(code, nome, preco, qtd);
			
			crudPanel.txtFiels.forEach((K,V) -> {V.setText("");});
			modelo.add(item);
			modelo.fireTableDataChanged();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Verifique os campos", "Ops!", JOptionPane.ERROR_MESSAGE);
		}
	}
	@Override
	protected void updateItem() {
		Cardapio item = modelo.getValueAtRow(tabela.getSelectedRow());
		if(item == null) {
			JOptionPane.showMessageDialog(this, "Selecione um item primeiro.", "Ops!", JOptionPane.ERROR_MESSAGE);
			return;
		}
		item.setId(Long.parseLong(crudPanel.txtFiels.get("id").getText()));
		item.setNome(crudPanel.txtFiels.get("nome").getText());
		item.setPreco(Double.parseDouble(crudPanel.txtFiels.get("preco").getText()));
		item.setQtd(Integer.parseInt(crudPanel.txtFiels.get("qtd").getText()));

		crudPanel.txtFiels.forEach((K,V) -> { V.setText("");});
		modelo.fireTableDataChanged();
	}
	@Override
	protected void deleteItem() {
		Cardapio item = modelo.getValueAtRow(tabela.getSelectedRow());
		if(item == null) {
			JOptionPane.showMessageDialog(this, "Selecione um item primeiro.", "Ops!", JOptionPane.ERROR_MESSAGE);
			return;
		}
		modelo.delete(item);
		crudPanel.txtFiels.forEach((K,V) -> { V.setText("");});
		modelo.fireTableDataChanged();
	}
}
