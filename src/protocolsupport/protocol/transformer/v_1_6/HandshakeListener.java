package protocolsupport.protocol.transformer.v_1_6;

import net.minecraft.server.v1_8_R3.NetworkManager;
import protocolsupport.protocol.transformer.AbstractHandshakeListener;

public class HandshakeListener extends AbstractHandshakeListener {

	public HandshakeListener(NetworkManager networkmanager) {
		super(networkmanager);
	}

	@Override
	public LoginListener getLoginListener(NetworkManager networkManager) {
		return new LoginListener(networkManager);
	}

}
