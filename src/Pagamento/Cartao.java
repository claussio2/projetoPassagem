package Pagamento;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Cartao {
	
	private String numero;
	private String anoVencimento;
	private String mesVencimento;
	private String codigoDeSeguranca;
	private Conta conta;
	private static String[] bandeiraAceitas = {"Visa","MasterCard","Elo"};
	private String bandeiraDigitadaUsuario;
	private DateFormat df = new SimpleDateFormat("yyyyMMdd");
	private Date vencimentoCartao;
	private Date dataAtual;
	
	public Cartao() {
		
	}
	
	public Cartao(String numero, String anoVencimento, String mesVencimento, String codigoDeSeguranca, Conta conta,String bandeiraDigitadaUsuario) throws ParseException {
		this.numero = numero;
		this.codigoDeSeguranca = codigoDeSeguranca;
		this.conta = conta;
		this.bandeiraDigitadaUsuario = bandeiraDigitadaUsuario;
		this.anoVencimento = anoVencimento;
		this.mesVencimento = mesVencimento;
		this.vencimentoCartao = df.parse(anoVencimento+mesVencimento+"01");
		this.dataAtual = new Date();
		
		
	}

	public String getNumero() {
		return numero;
	}

	public String getCodigoDeSeguranca() {
		return codigoDeSeguranca;
	}

	public Conta getConta() {
		return conta;
	}
	
	public String mostraDadosDoCartao() {
		return numero.substring(0,4) + "-" + numero.substring(4,8) + "-xxxxxx";
	}
	
	public boolean cartaoValidoOuNao(Cartao cartao){
		 boolean verificaBandeira = false;
		 
		 //Percorre vetor de bandeiras aceitas
		 for(int i = 0; i < bandeiraAceitas.length;i++) {
			 if(bandeiraAceitas[i].equals(bandeiraDigitadaUsuario)) {
				 verificaBandeira = true;
			 }
			 else {
				 verificaBandeira = false;
			 }
		 }
		 
		if(verificaBandeira = false) {
			System.out.println("Bandeira n�o aceita");
			return false;
		}
		
		else if(numero.length() < 16 || numero.length() > 16) {
		 	System.out.println("N�mero cart�o inv�lido"); //As bandeiras que nosso sistema aceita os cart�es s� tem 16 digitos
			 return false;
		 }
			
		 else if(vencimentoCartao.before(dataAtual)) {
			 System.out.println("Cart�o vencido"); // Verifica se cart�o est� vencido ou n�o
			 return false;
		 }
		 
		 
		 else if(codigoDeSeguranca.length() > 3) {
			 System.out.println("C�digo de seguran�a inv�lido");
			 return false;											//Cart�es no geral tem c�digo de seguran�a menor do que 4 d�gitos
		 }
		 
		 else {
			 return true;
		 }
	}
	
}
