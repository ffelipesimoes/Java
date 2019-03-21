package noobChain;

import java.security.PublicKey;

public class TransactionOutputs {
	public String id;
	//also known as the new owner of these coins.
	public PublicKey reciepient; 
	//the amount of coins they own
	public float value; 
	//the id of the transaction this output was created in
	public String parentTransactionId; 
	
	public TransactionOutputs(PublicKey reciepient, float value, String parentTrasactionId) {
		this.reciepient = reciepient;
		this.value = value;
		this.parentTransactionId = parentTrasactionId;
		this.id = StringUtil.applySha256(StringUtil.getStringFromKey(reciepient)+  Float.toString(value) + parentTrasactionId);
		
	}
	
	public boolean isMine(PublicKey publicKey) {
		return (publicKey == reciepient);
		
	}
}
