package classes;

import classes.exceptions.InputException;
import uteis.Categoria;
import uteis.TipoPrograma;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	
	private List<Programa> programas;

	public Biblioteca() {
		this.programas = new ArrayList<Programa>();
	}

	public List<Programa> getProgramas(){
		return this.programas;
	}

	public List<Programa> getProgramas(Categoria categoria) {

		List<Programa> programasFiltrados = new ArrayList<Programa>();

		for (Programa programa : this.programas) {
			if (programa.getCategoria() == categoria)
				programasFiltrados.add(programa);
		}

		return programasFiltrados;
	}

	public List<Programa> getProgramas(TipoPrograma tipoPrograma){

		List<Programa> programasFiltrados = new ArrayList<Programa>();

		for (Programa programa : this.programas) {
			if (programa.getTipoPrograma() == tipoPrograma)
				programasFiltrados.add(programa);
		}

		return programasFiltrados;
	}

	public List<Programa> getProgramas(Categoria categoria, TipoPrograma tipoPrograma) {

		List<Programa> programasFiltrados = new ArrayList<Programa>();

		for (Programa programa : this.programas) {
			if (programa.getTipoPrograma() == tipoPrograma)
				if(programa.getCategoria() == categoria)
					programasFiltrados.add(programa);
		}

		return programasFiltrados;
	}
	
	public Programa getPrograma(String nome) {

		for (Programa programa: this.programas) {
			if (programa.getNome().equalsIgnoreCase(nome))
				return programa;
		}

		return null;
	}

	public Programa getPrograma(String nome, TipoPrograma tipoPrograma) {

		for (Programa programa: this.programas) {
			if (programa.getNome().equalsIgnoreCase(nome) && programa.getTipoPrograma() == tipoPrograma)
				return programa;
		}

		return null;
	}

	public void addPrograma(Programa programa) throws InputException.BibliotecaException {
		InputException.BibliotecaException.programaJaCadastrado(programa.getNome(), this, programa.getTipoPrograma());
		programas.add(programa);
	}

	public void editarPrograma(Programa programa) throws InputException.BibliotecaException {
		InputException.BibliotecaException.programaNaoCadastrado(programa.getNome(), this, programa.getTipoPrograma());
		Integer index = this.programas.indexOf(this.getPrograma(programa.getNome(), programa.getTipoPrograma()));
		this.programas.set(index, programa);
	}

	public void excuirPrograma(Programa programa) throws InputException.BibliotecaException {
		InputException.BibliotecaException.programaNaoCadastrado(programa.getNome(), this, programa.getTipoPrograma());
		this.programas.remove(programa);
	}
}