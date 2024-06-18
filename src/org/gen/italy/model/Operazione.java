package org.gen.italy.model;

//sottoclasse di Programma: "eredita" nome e durata 
public class Operazione extends Programma {
		private boolean presenzaAcqua;

		public Operazione(String nome, int durata, boolean detersivoNecessario, boolean presenzaAcqua) throws Exception {
			super(nome, durata,detersivoNecessario);
			this.presenzaAcqua = presenzaAcqua;
		}

		public boolean isPresenzaAcqua() {
			return presenzaAcqua;
		}
		
		
		
		@Override
		public String toString() {
			return "Operazione [nome=" + nome + ", durata=" + durata
					+ ", detersivoNecessario=" + detersivoNecessario + ", presenzaAcqua=" + presenzaAcqua + "]";
		}

	}
	

