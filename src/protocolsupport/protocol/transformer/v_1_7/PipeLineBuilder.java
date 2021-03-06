package protocolsupport.protocol.transformer.v_1_7;

import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;
import net.minecraft.server.v1_8_R3.NetworkManager;
import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.pipeline.ChannelHandlers;
import protocolsupport.protocol.pipeline.IPipeLineBuilder;
import protocolsupport.protocol.transformer.v_1_7.clientboundtransformer.PacketEncoder;
import protocolsupport.protocol.transformer.v_1_7.serverboundtransformer.PacketDecoder;

public class PipeLineBuilder implements IPipeLineBuilder {

	@Override
	public void buildPipeLine(Channel channel, ProtocolVersion version) {
		ChannelPipeline pipeline = channel.pipeline();
		NetworkManager networkmanager = (NetworkManager) pipeline.get(ChannelHandlers.NETWORK_MANAGER);
		networkmanager.a(new HandshakeListener(networkmanager));
		ChannelHandlers.getSplitter(pipeline).setRealSplitter(new PacketSplitter());
		ChannelHandlers.getPrepender(pipeline).setRealPrepender(new PacketPrepender());
		ChannelHandlers.getDecoder(pipeline).setRealDecoder(new PacketDecoder(version));
		ChannelHandlers.getEncoder(pipeline).setRealEncoder(new PacketEncoder(version));
	}

}
