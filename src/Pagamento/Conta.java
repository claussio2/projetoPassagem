package Pagamento;

public class Conta {
	private double saldo;
	//private Pessoa pessoa;
	public Conta(double saldo) {
		this.saldo = saldo;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public boolean realizaCompra(double valor,Cartao cartao) {  //Metodo respons�vel por cobrar a passagem. Primeiro verifica se o cart�o � valido e depois autoriza a compra
		if(cartao.cartaoValidoOuNao(cartao)==true) {
			if (saldo >= valor) {
				saldo -= valor;
				System.out.println("Compra aprovada");
				return true;
			}
			else {
				System.out.println("Compre negada. Saldo indispon�vel");
				return false;
			}
		}
		
		else {
			return false;
		}
		
	}

	
}
