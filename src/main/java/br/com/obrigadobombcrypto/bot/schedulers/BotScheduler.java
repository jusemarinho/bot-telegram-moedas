package br.com.obrigadobombcrypto.bot.schedulers;

import br.com.obrigadobombcrypto.bot.service.EchoBotService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class BotScheduler {

    @Scheduled(fixedRate = 3600000)
    public void execute() {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new EchoBotService());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
