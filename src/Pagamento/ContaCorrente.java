package Pagamento;

import java.util.Scanner;

public class ContaCorrente extends Conta {
	private double limite;

	public ContaCorrente(double limite, double saldo) {
		super(saldo);
		this.limite = limite;

	}

	public double getLimite() {
		return limite;
	}

	@Override
	public boolean realizaCompra(double valor, Cartao cartao) { // Metodo respons�vel por cobrar a passagem. Primeiro verifica se o cart�o � valido e depois autoriza a compra
		Scanner sc = new Scanner(System.in);
		if (cartao.cartaoValidoOuNao(cartao) == true) {
			
			System.out.println("Digite 1 para pagar no d�bito e 2 para pagar no cr�dito");
			int opcao = sc.nextInt();
			if (opcao == 1) {
				return super.realizaCompra(valor,cartao);
			}
			
			else {
				if (limite >= valor) {
					limite -= valor;
					System.out.println("Compra aprovada");
					return true;
				} 
				else {
					System.out.println("Compra negada. Limite indispon�vel");
					return false;

				}
			}
			
		}
		
		else {
			return false;
		}
	}

}
