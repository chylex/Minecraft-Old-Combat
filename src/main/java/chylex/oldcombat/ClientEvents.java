package chylex.oldcombat;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import static net.minecraftforge.fml.common.eventhandler.EventPriority.LOWEST;

public final class ClientEvents{
	@SubscribeEvent(priority = LOWEST, receiveCanceled = true)
	public void onGuiOpen(GuiOpenEvent e){
		MinecraftForge.EVENT_BUS.unregister(this);
		Minecraft.getMinecraft().gameSettings.attackIndicator = 0;
	}
}
