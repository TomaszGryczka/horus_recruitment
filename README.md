# Analiza
Zadanie polega na tym, że mamy bloki, które mają swój kolor oraz materiał, z którego zostały wykonane. 
Bloki te mogą się składać z pojedynczego bloku lub ze złożenia wielu bloków (bloki składające się na jeden blok także
mogą składać się z wielu bloków).

Zbiór wielu bloków nazywamy strukturą (przykładem takiej struktury w tym zadaniu jest ściana). Ściana zawiera listę bloków,
które się na nią składają. Moim zadaniem było zaimplementowanie dla klasy Wall następujących metod:
- findBlockByColor - zwraca dowolny blok o podanym kolorze,
- findBlocksByMaterial - zwraca wszystkie bloki z danego materiału,
- count - zwraca liczbę wszystkich pojedynczych bloków.

Aby wykonać to zadanie założyłem, że blok, na którego składa się wiele innych bloków nie ma swojego koloru oraz materiału, ponieważ
każda składowa tego bloku może mieć inny kolor, materiał. Z powodu prośby o zaimplementowanie całej logiki w klasie Wall nie zmieniałem
podanych już wcześniej interfejsów, zamiast tego do każdej z powyższych metod dopisałem metodę prywatną. Metody prywatne wywoływały
się rekurencyjnie, aby w przypadku pojawienia się złożenia wielu bloków "rozbić" je na części.
