package chylex.oldcombat;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import static net.minecraftforge.fml.common.eventhandler.EventPriority.HIGHEST;

@Mod(modid = "oldcombat", useMetadata = true, acceptableRemoteVersions = "*")
public final class OldCombatMod{
	@EventHandler
	public void onPreInit(FMLPreInitializationEvent e){
		MinecraftForge.EVENT_BUS.register(this);
		
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT){
			MinecraftForge.EVENT_BUS.register(new ClientEvents());
		}
	}
	
	@SubscribeEvent(priority = HIGHEST)
	public void onPlayerAttackTarget(AttackEntityEvent e){
		e.getEntityPlayer().ticksSinceLastSwing = 1000;
	}
}
