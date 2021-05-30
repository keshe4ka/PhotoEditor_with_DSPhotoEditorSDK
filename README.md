# Курсач разработки мобильных приложений

## План работ (29.05.21 20:48)

### Что не работает:
1. Остались траблы с сохранием и выборе камеры на Nexus 5x (эмулятор норм)
2. Кнопка крестик в редакторе и кнопка обратно в ResultActivity ведут себя неккоректно


### Планы (по важности):
1. Фикс багов для Nexus 5x
___________________________________________________________________________________________________________
## Гайд по изменению .aar:


Разобрали:
```bash
unzip ds-photo-editor-sdk-v10.aar -d tempFolder
```
Cобрали:
```bash
cd tempFolder
zip -r ../ds-photo-editor-sdk-v10.aar *
```

> Мануалы для вкуривания:
> > https://www.dsphotoeditor.com/android
> 
> > https://developer.android.com/topic/libraries/view-binding#kts
