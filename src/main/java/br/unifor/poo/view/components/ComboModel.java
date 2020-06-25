package br.unifor.poo.view.components;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/* ComboBoxModel<T> extends ListModel<E>
 * ComboBoxModel<T> possui 2 mÃ©todos a implementar: getSelectedItem e setSelectedItem
 * ListModel<E> possui 2 mÃ©todos que serÃ£o implementados aqui: getElementAt e getSize
 * ListModel<E> possui 2 mÃ©todos implementados por AbstractListModel<E>: addListDataListener e removeListDataListener
 * AbstractListModel<E> tambÃ©m implementa:
	fireContentsChanged(Object source, int index0, int index1)//Visa atualizar todo o conteÃºdo do JComboBox.
	fireIntervalAdded(Object source, int index0, int index1)//Visa atualizar o intervalo de dados que foram inseridos no JComboBox.
	fireIntervalRemoved(Object source, int index0, int index1)//Visa atualizar o intervalo de dados que foram removidos no JComboBox.
 */

@SuppressWarnings("serial")
public class ComboModel<T> extends AbstractListModel<T> implements ComboBoxModel<T> {
	private List<T> listT;
	private T selectedItem;
	private final static int FIRSTINDEX = 0;

	public ComboModel() {
		this.listT = new ArrayList<T>();
	}

	public ComboModel(List<T> listT) {
		this();
		this.listT.addAll(listT);
		if (this.getSize() > 0) {
			setSelectedItem(this.listT.get(FIRSTINDEX));
		}
	}
	@Override
	public T getSelectedItem() {
		return selectedItem;
	}// ComboBoxModel: usado pelo JComboBox para retornar o objeto que esta selecionado

	@SuppressWarnings("unchecked")
	@Override
	public void setSelectedItem(Object anItem) {
		selectedItem = (T) anItem;
	}// ComboBoxModel: usado pelo JComboBox para setar o objeto que estÃ¡ selecionado

	@Override
	public T getElementAt(int index) {
		if (listT.size() > 0)
			return listT.get(index);
		else
			return null;
	}// ListModel: recebe um int que serÃ¡ usado como Ã­ndice para retornar um objeto
		// da lista

	@Override
	public int getSize() {
		return listT.size();
	}// ListModel: total de itens no nosso JComboBox

	public void addItem(T item) {
		listT.add(item);
		fireIntervalAdded(this, getSize() - 1, getSize() - 1);
		setSelectedItem(listT.get(getSize() - 1));
	}

	public void addListItem(List<T> itens) {
		int primeiraLinha = getSize();
		listT.addAll(itens);
		fireIntervalAdded(this, primeiraLinha, primeiraLinha + itens.size());
		setSelectedItem(listT.get(getSize() - 1));
	}

	public void removeItem() {
		listT.remove(getSelectedItem());
		fireIntervalRemoved(this, FIRSTINDEX, getSize() - 1);
		setSelectedItem(listT.get(FIRSTINDEX));
	}

	public void clear() {
		listT.clear();
		fireContentsChanged(this, FIRSTINDEX, getSize() - 1);
	}
}
