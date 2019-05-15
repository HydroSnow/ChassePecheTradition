package fr.hydrosnow.hydrobot.qf;

import net.dv8tion.jda.core.*;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

/* =====
 * Librairie utilisée : JDA
 * https://github.com/DV8FromTheWorld/JDA
 * =====
 */

public class HydroBotQf extends ListenerAdapter {
	private JDA jda;
	
	public HydroBotQf() {
		try {
			connect();
		} catch (LoginException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void connect() throws LoginException, InterruptedException {
		if (jda == null) {
			System.out.println("[qf] Connecting...");
			final JDABuilder jdabuilder = new JDABuilder(AccountType.BOT);
			jdabuilder.setToken("{token}");
			jdabuilder.setStatus(OnlineStatus.ONLINE);
			jdabuilder.addEventListener(this);
			jdabuilder.setGame(Game.playing("Blague trop drôle"));
			jda = jdabuilder.build();
			jda.awaitReady();
			
			System.out.println("[qf] Connected!");
			
		} else {
			throw new IllegalStateException("Tried to connect an already connected bot");
		}
		
	}

	public void disconnect() {
		if (jda != null) {
			System.out.println("[qf] Disconnecting...");
			jda.shutdown();
			jda = null;
			
			System.out.println("[qf] Disconnected!");
			
		} else {
			throw new IllegalStateException("Tried to disconnect a not connected bot");
		}
		
	}
	
	@Override
	public void onMessageReceived(final MessageReceivedEvent ev) {
		String msg = ev.getMessage().getContentDisplay();
		msg = msg.replace(" ", "");
		msg = msg.replace("?", "");
		msg = msg.replace("!", "");
		msg = msg.replace(".", "");
		msg = msg.toLowerCase();
		
		if (msg.endsWith("quoi")) {
			final String reply = ev.getMessage().getAuthor().getAsMention() + " feur";
			ev.getChannel().sendMessage(reply).submit();
		}
		
	}
}
