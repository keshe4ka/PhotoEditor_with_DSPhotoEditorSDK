# PhotoEditor_with_DSPhotoEditorSDK

##План работ (20.05.21 00:30)

###Что не работает:
1. Сохранение обработанной фотки
2. Вылет у меня на Nexus 5x после выбора камеры (на симе все норм)
3. Не загружается обработанная фотка в results_activity (там есть объект image, 
          на нем стоит андроидная голова, вместо нее должна отображаться отредаченная фотка),
          это может быть связано с пунктом 1

###Что не доделано:
1. Кнопки поделиться (инст, фб, еще неплохо найти логотип вк и туда его еще)
2. Кнопки выхода в главное меню и возврата назад (в обработчик фотки)

###Планы:
1. Починить баги, сделать несделанное
2. Залезть в libs/, в ds_photo_editor и заменить там ужасные иконки на Goggle Material Icons
           (я там поглядел, что они все в png, возможно где-то прячется xml разметка, но заменить png будет проще)
           ссылка на GMI - https://fonts.google.com/icons
3. Нарисовать логотип, сделать иконку приложения, добавить логотип на main_activity вместо головы дроида
4. Поработать с шрифтами (если потребуется)
5. Вылизать дизайн
6. При нехватки времени на фикс багов - тщательно замаскировать
7. Сделать пасхалку - при пятикратном нажатии на лого в main_activity вывести какой-нибудь текст куда-нибудь
