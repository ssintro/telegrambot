package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends TelegramLongPollingBot {

    private Map<Long, Integer> levels = new HashMap<>();


    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(new Main());
//        Banderogoos2Bot
//        6070801441:AAHyHqY1VH4RElkmoZhaBjP5pGlahqnsLng
    }

    @Override
    public String getBotUsername() {
        return "Banderogoos2Bot";
    }

    @Override
    public String getBotToken() {
        return "6070801441:AAHyHqY1VH4RElkmoZhaBjP5pGlahqnsLng";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Long chatId = getChatId(update);

        List<String> buttons = Arrays.asList(
                "Злітати на тестовий рейд по чотирьох позиціях (+15 монет)",
                "Відвезти гуманітарку на передок (+15 монет)",
                "Знайти зрадника та здати в СБУ (+15 монет)",
                "Навести арту на орків (+15 монет)",
                "Притягнути танк трактором (+15 монет)",
                "Зібрати комарів для нової біологічної зброї (+15 монет)",
                "Пройти курс молодого бійця (+15 монет)",
                "Задонатити на ЗСУ (+15 монет)",
                "Збити дрона банкою огірків (+15 монет)",
                "Зробити запаси коктейлів Молотова (+15 монет)",
                "Сплести маскувальну сітку (+15 монет)",
                "Зібрати кошти патріотичними піснями (+15 монет)",
                "Вступити в Міністерство Мемів України (+15 монет)",
                "Запустити волонтерську акцію (+15 монет)",
                "Вступити до лав тероборони (+15 монет)"
        );

        if (update.hasMessage() && update.getMessage().getText().equals("/start")) {
            sendImage("level-1", chatId);

            SendMessage message = createMessage("Ґа-ґа-ґа!\n" +
                    "Вітаємо у боті біолабораторії «Батько наш Бандера».\n" +
                    "\n" +
                    "Ти отримуєш гусака №71\n" +
                    "\n" +
                    "Цей бот ми створили для того, щоб твій гусак прокачався з рівня звичайної свійської худоби до рівня біологічної зброї, здатної нищити ворога. \n" +
                    "\n" +
                    "Щоб звичайний гусак перетворився на бандерогусака, тобі необхідно:\n" +
                    "✔виконувати завдання\n" +
                    "✔переходити на наступні рівні\n" +
                    "✔заробити достатню кількість монет, щоб придбати Джавеліну і зробити свєрхтра-та-та.\n" +
                    "\n" +
                    "*Гусак звичайний.* Стартовий рівень.\n" +
                    "Бонус: 5 монет.");
            message.setChatId(chatId);
            sendApiMethodAsync(message);

            SendMessage message1 = createMessage("Обери завдання, щоб перейти на наступний рівень");
            message1.setChatId(chatId);

            buttons = getRandoms3(buttons);

            attachButtons(message1, Map.of(
                    buttons.get(0), "level_1_task",
                    buttons.get(1), "level_1_task",
                    buttons.get(2), "level_1_task"
            ));

            sendApiMethodAsync(message1);
        }


            if (update.hasCallbackQuery()) {

                if (update.getCallbackQuery().getData().equals("level_1_task") && getLevel(chatId) == 1) {

                    setLevel(chatId, 2);

                    sendImage("level-2", chatId);

                    SendMessage message2 = createMessage("*Вітаємо на другому рівні! Твій гусак - біогусак.*\n" +
                            "Баланс: 20 монет. \n" +
                            "Обери завдання, щоб перейти на наступний рівень");
                    message2.setChatId(chatId);

                    attachButtons(message2, Map.of(
                            buttons.get(0), "level_2_task",
                            buttons.get(1), "level_2_task",
                            buttons.get(2), "level_2_task"
                    ));
                    sendApiMethodAsync(message2);
                }

                if (update.getCallbackQuery().getData().equals("level_2_task") && getLevel(chatId) == 2){

                    setLevel(chatId, 3);

                    sendImage("level-3", chatId);

                    SendMessage message3 = createMessage("*Вітаємо на третьому рівні! Твій гусак - бандеростажер.*\n" +
                            "Баланс: 35 монет. \n" +
                            "Обери завдання, щоб перейти на наступний рівень");
                    message3.setChatId(chatId);

                    attachButtons(message3, Map.of(
                            buttons.get(0), "level_3_task",
                            buttons.get(1),   "level_3_task",
                            buttons.get(2),    "level_3_task"
                    ));
                    sendApiMethodAsync(message3);
                }

                if (update.getCallbackQuery().getData().equals("level_3_task") && getLevel(chatId) == 3) {

                    setLevel(chatId, 4);

                    sendImage("level-4", chatId);

                    SendMessage message4 = createMessage("*Вітаємо на останньому рівні! Твій гусак - готова біологічна зброя - бандерогусак.*\n" +
                            "Баланс: 50 монет. \n" +
                            "Тепер ти можеш придбати Джавелін і глушити чмонь");
                    message4.setChatId(chatId);

                    attachButtons(message4, Map.of(
                            "Купити Джавелін (50 монет)", "level_4_task"));
                    sendApiMethodAsync(message4);
                }

                if (update.getCallbackQuery().getData().equals("level_4_task") && getLevel(chatId) == 4){

                    setLevel(chatId, 5);

                    SendMessage message5 = createMessage("*Джавелін твій. Повний вперед!*");
                    message5.setChatId(chatId);

                    sendApiMethodAsync(message5);

                    sendImage("final", chatId);

                }
            }
    }


    public  Long getChatId(Update update){
        if (update.hasMessage()){
            return  update.getMessage().getFrom().getId();
        }

        if (update.hasCallbackQuery()){
            return update.getCallbackQuery().getFrom().getId();
        }

        return null;
    }

    public SendMessage createMessage(String text){
        SendMessage message = new SendMessage();
        message.setText(new String(text.getBytes(), StandardCharsets.UTF_8));
        message.setParseMode("markdown");
        return message;
    }

    public void attachButtons(SendMessage message, Map<String, String> buttons){

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keybord = new ArrayList<>();

        for (String buttonName : buttons.keySet()) {
            String buttonValue = buttons.get(buttonName);

            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText(new String(buttonName.getBytes(), StandardCharsets.UTF_8));
            button.setCallbackData(buttonValue);

            keybord.add(Arrays.asList(button));
        }

        markup.setKeyboard(keybord);

        message.setReplyMarkup(markup);
    }

    public void sendImage(String name, Long chatId){
        SendAnimation animation = new SendAnimation();

        InputFile inputFile = new InputFile();
        inputFile.setMedia(new File("src/images/" + name + ".gif"));

        animation.setAnimation(inputFile);
        animation.setChatId(chatId);

        executeAsync(animation);
    }

    public int getLevel(Long chatId){
        return levels.getOrDefault(chatId, 1);
    }

    public void setLevel(Long chatId, int level){
        levels.put(chatId, level);
    }

    private List<String> selectedVariants = new ArrayList<>();

    public  List<String> getRandoms3(List<String> variants){
        ArrayList<String> copy = new ArrayList<>(variants);
        copy.removeAll(selectedVariants); // виключаємо вибрані елементи зі списку

        Collections.shuffle(copy);
        List<String> selected = copy.subList(0, Math.min(3, copy.size())); // вибираємо не більше 3 елементів
        selectedVariants.addAll(selected); // додаємо вибрані елементи до списку вже вибраних
        return selected;
    }
}