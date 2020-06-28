package br.unifor.poo.view.frames;

import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import br.unifor.poo.modelo.Cardapio;
import br.unifor.poo.modelo.Cliente;
import br.unifor.poo.view.components.IDialogT;
import br.unifor.poo.view.util.Misc;

@SuppressWarnings("serial")
public class DialogCliente extends IDialogT<Cliente> {
	public DialogCliente(Cliente _item, Frame parentFrame, String title, int width, int height) {
		super(_item, parentFrame, title, width, height);
	}
	public DialogCliente(Cliente _item, JDialog parentFrame, String title, int width, int height) {
		super(_item, parentFrame, title, width, height);
	}

	protected void events() {
		super.events();
		tabela.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1 && tabela.getSelectedRow() != -1) {
		        	Cliente c = modelo.getValueAtRow(tabela.getSelectedRow());
		        	
		        	crudPanel.txtFiels.get("id").setText(c.getId()+"");
		        	crudPanel.txtFiels.get("nome").setText(c.getNome()+"");
		        	crudPanel.txtFiels.get("endereco").setText(c.getEndereco()+"");
		        	crudPanel.txtFiels.get("ativo").setText(c.isAtivo()+"");
		        }
		    }
		});
	}
	
	@Override
	public void newItem() {
		try {
			Long code = Misc.code++;
			String nome = crudPanel.txtFiels.get("nome").getText();
			String endereco = crudPanel.txtFiels.get("endereco").getText();
			String ativo = crudPanel.txtFiels.get("ativo").getText();
			if(nome.isEmpty() || endereco.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Verifique os campos vazios.", "Ops!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			Cliente item = new Cliente(code, nome, endereco);
			
			if(ativo.equals("nao") || ativo.equals("não")) {
				item.setAtivo(false);
			}
			crudPanel.txtFiels.forEach((K,V)->{ V.setText(""); });
			modelo.add(item);
			modelo.fireTableDataChanged();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Verifique os campos", "Ops!", JOptionPane.ERROR_MESSAGE);
		}
	}
	@Override
	public void updateItem() {
		Cliente item = modelo.getValueAtRow(tabela.getSelectedRow());
		if(item == null) {
			JOptionPane.showMessageDialog(this, "Selecione um item primeiro.", "Ops!", JOptionPane.ERROR_MESSAGE);
			return;
		}
		item.setId(Long.parseLong(crudPanel.txtFiels.get("id").getText()));
		item.setNome(crudPanel.txtFiels.get("nome").getText());
		item.setEndereco(crudPanel.txtFiels.get("endereco").getText());
		item.setAtivo(Boolean.parseBoolean(crudPanel.txtFiels.get("ativo").getText()));
		crudPanel.txtFiels.forEach((K,V)->{ V.setText(""); });
		modelo.fireTableDataChanged();
	}
	@Override
	public void deleteItem() {
		Cliente item = modelo.getValueAtRow(tabela.getSelectedRow());
		if(item == null) {
			JOptionPane.showMessageDialog(this, "Selecione um item primeiro.", "Ops!", JOptionPane.ERROR_MESSAGE);
			return;
		}
		modelo.delete(item);
		crudPanel.txtFiels.forEach((K,V)->{ V.setText(""); });
		modelo.fireTableDataChanged();
	}
}