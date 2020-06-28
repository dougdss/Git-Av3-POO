package br.unifor.poo.view.frames;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.unifor.poo.modelo.Cardapio;
import br.unifor.poo.modelo.Cliente;
import br.unifor.poo.modelo.ItemPedido;
import br.unifor.poo.modelo.Pedido;
import br.unifor.poo.services.DadosTest;
import br.unifor.poo.view.components.ComboModel;
import br.unifor.poo.view.components.IDialogT;
import br.unifor.poo.view.components.TableModel;
import br.unifor.poo.view.util.Misc;

@SuppressWarnings("serial")
public class DialogPedido extends IDialogT<Pedido> {
	protected ComboModel<Cardapio> comboCardapio= null;
	protected JComboBox<Cardapio> comboBoxCardapio = null;
	protected ComboModel<Cliente> comboCliente = null;
	protected JComboBox<Cliente> comboBoxCliente = null;
	protected TableModel<ItemPedido> tableItem= null;

	public DialogPedido(Pedido _item, Frame parentFrame, String title, int width, int height) {
		super(_item, parentFrame, title, width, height);
	}

	protected void events() {
		super.events();
		tabela.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        if (mouseEvent.getClickCount() == 1 && tabela.getSelectedRow() != -1) {
//		        	Pedidos p = modelo.getValueAtRow(tabela.getSelectedRow());
//		        	
//		        	crudPanel.txtFiels.get("id").setText(p.getId()+"");
//		        	crudPanel.txtFiels.get("cliente").setText(p.getCliente().getId()+"");
//		        	crudPanel.txtFiels.get("situacao").setText(p.getSituacao()+"");
//		        	crudPanel.txtFiels.get("data").setText(p.getData().toString()+"");
		        }
		    }
		});
	}
	
	@Override
	protected void setCrudComponents() {
		super.setCrudComponents();
		comboCardapio = new ComboModel<Cardapio>();
		comboBoxCardapio = new JComboBox<Cardapio>(comboCardapio);
		comboCardapio.addListItem(DadosTest.cardapios);
		
		comboCliente = new ComboModel<Cliente>();
		comboBoxCliente = new JComboBox<Cliente>(comboCliente);
		comboCliente.addListItem(DadosTest.clientes);

		comboBoxCardapio.setFont(Misc.FONT);
		comboBoxCliente.setFont(Misc.FONT);
		this.crudPanel.insertComponets(comboBoxCardapio, comboBoxCliente);
		
		JTextField clienteTxt = crudPanel.txtFiels.get("cliente");
		clienteTxt.setEnabled(false);
		
		comboBoxCliente.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent event) {
				  if (event.getStateChange() == ItemEvent.SELECTED)
                  {
                       try
                       {
                            String value = comboBoxCliente.getSelectedItem().toString();
                            clienteTxt.setText(value);
                       }
                       catch (Exception ex)
                       {
                            ex.printStackTrace();
                       }
                  }
             }
		});
		
		JTextField itensTxt = crudPanel.txtFiels.get("itens");
		itensTxt.setEnabled(false);
		
		comboBoxCardapio.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent event) {
				  if (event.getStateChange() == ItemEvent.SELECTED)
                  {
                       try
                       {
                            String value = comboBoxCardapio.getSelectedItem().toString();
                            itensTxt.setText(itensTxt.getText().toString() + "---" + value);
                       }
                       catch (Exception ex)
                       {
                            ex.printStackTrace();
                       }
                  }
             }
		});
	}
	
	@Override
	public void newItem() {
		try {
			Long code = Misc.code++;
			String situacao = crudPanel.txtFiels.get("situacao").getText();
			String data = crudPanel.txtFiels.get("data").getText();
			
			if(comboBoxCliente.getSelectedItem() == null || comboBoxCardapio.getSelectedItem() == null) {
				JOptionPane.showMessageDialog(this, "Verifique os campos vazios.", "Ops!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			Cliente cli = (Cliente) comboBoxCliente.getSelectedItem();
			
			Pedido item = new Pedido(cli);
			
			Cardapio card = (Cardapio) comboBoxCardapio.getSelectedItem();
			
			ItemPedido ped = new ItemPedido(code, item, card, 1);
			item.addItem(ped);
			
			crudPanel.txtFiels.forEach((K,V)->{ V.setText(""); });
			modelo.add(item);
			modelo.fireTableDataChanged();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Verifique os campos", "Ops!", JOptionPane.ERROR_MESSAGE);
		}
	}
	@Override
	public void updateItem() {
//		Pedido item = modelo.getValueAtRow(tabela.getSelectedRow());
//		if(item == null) {
//			JOptionPane.showMessageDialog(this, "Selecione um item primeiro.", "Ops!", JOptionPane.ERROR_MESSAGE);
//			return;
//		}
//		item.setId(Long.parseLong(crudPanel.txtFiels.get("id").getText()));
//		Cliente cli = new Cliente(crudPanel.txtFiels.get("cliente").getText(), "");
//		item.setCliente(cli);
//		item.setSituacao(crudPanel.txtFiels.get("situacao").getText());
//		
//		crudPanel.txtFiels.forEach((K,V)->{ V.setText(""); });
//		modelo.fireTableDataChanged();
	}
	
	@Override
	public void deleteItem() {
//		Pedido item = modelo.getValueAtRow(tabela.getSelectedRow());
//		if(item == null) {
//			JOptionPane.showMessageDialog(this, "Selecione um item primeiro.", "Ops!", JOptionPane.ERROR_MESSAGE);
//			return;
//		}
//		modelo.delete(item);
//		crudPanel.txtFiels.forEach((K,V)->{ V.setText(""); });
//		modelo.fireTableDataChanged();
	}
}

