# ajou-dirtycode
Dirty code for refactoring


Test Code 작성(모든 경우 고려)

아이템 이름이 Sulfuras, Hand of Ragnaros인 경우
   1) 변화 없음
------------------------------------------------------------------------------
아이템 이름이 Aged Brie인 경우
   1) quality >= 50이면 sellin 1 감소
   2) quality = 49이면 quality 1 증가, sellin 1 감소
   3) quality < 49, sellin >= 1이면 quality 1 증가, sellin 1 감소
   4) quality < 49, sellin < 1이면 quality 2 증가, sellin 1 감소
-------------------------------------------------------------------------------
아이템 이름이 Backstage passes to a TAFKAL80ETC Concert인 경우
   1) sellin < 1이면 quality = 0, sellin 1 감소
   2) quality >= 50이라면 sellin 1 감소 //
   3) quality = 49이면 quality 1 증가, sellin 1 감소
   4) quality = 48, 1<= sellin <11이라면 quality 2 증가, sellin 1 감소
   5) quality <= 47, 1<= sellin < 6이라면 quality 3 증가, sellin 1 감소
   6) quality <= 47, 6<= sellin < 11이라면 quality 2 증가, sellin 1 감소
   7) quality <= 49, sellin >= 11이면 quality 1 증가, sellin 1 감소
--------------------------------------------------------------------------------
아이템 이름이 위 3개가 아닌 경우
   1) quality > 1, sellin < 1이면 quality 2 감소, sellin 1 감소
   2) 0< quality <= 1, sellin < 1이면 quality 1 감소, sellin 1 감소
   3) quality <= 0이면 sellin 1 감소
   4) quality > 1, sellin >= 1이면 quality 1 감소, sellin 1 감소
   
----------------------------------------------------------------------------------
리팩토링 과정
   1) 먼저 원본 코드에서 전부 통과되는 테스트 16개를 작성
   1) 반복문을 사용하여 updateQuality메소드가 실행될때마다 아이템의 상태가 어떻게 바뀌는지 파악
   2) 아이템 이름이 설퍼라스, 라그라노스의 손인 경우 아무것도 바뀌지 않지만, 다른 경우 sellin의 값이 감소하며 그에 맞춰 quality가 변화
   3) quality의 값이 증가할지 감소할지는 아이템의 이름의 영향을 많이 받기에 코드의 분기 기준을 아이템의 이름으로 잡음
   4) 아이템의 이름이 설퍼라스일때, 숙성된 치즈일때, 콘서트 입장권일때, 이중 어느것도 아닐때, 이렇게 4가지로 나눌수 있도록 if문을 작성
   5) 이에 맞춰 코드를 다시 재구성
   6) 재구성된 코드에서 아이템 클래스의 변수값을 기준으로 true, false를 나누는 부분을 extract method로 추출하여 코드를 보기 쉽게 바꿈
   8) 테스트코드를 작동시켜보며 테스트가 전부 통과되도록 코드를 수정함
   9) 코드량을 줄이고 알아보기 쉽게 하도록 updateQuality메소드를 if, else가 아닌 switch구문으로 수정
----------------------------------------------------------------------------------
코드 해석
   1) Item 클래스
   
   name : 아이템의 이름
   
   sellin: 유효기간 또는 남은기간
   
   quality : 아이템의 퀄리티, 아이템의 name과 sellin의 영향을 받음, 최대값은 50, 최소값은 0
   
   2) DirtySample
   a. updateQuality
   - 아이템배열의 아이템의 이름에 따라 아이템을 업데이트함
   - 아이템의 이름이 Sulfuras, Hand of Ragnaros인경우 달라지는게 없음
   - 그 외의 경우, 업데이트할때마다 시간이 흐른것으로 보고 sellin값이 1씩 감소
   - 아이템의 이름이 Aged Brie(숙성된 치즈)인 경우, 업데이트할때마다 시간이 흐른것으로 보고 치즈가 숙성이되면서 quality값이 1씩 증가함. sellin이      0밑으로 떨어지면 quality값이 2씩 증가함
   - 아이템의 이름이 Backstage passes to a TAFKAL80ETC Concert인 경우, 업데이트 할때마다 시간이 흐른것으로 보고 점점 콘서트 날짜가 다가오면서 티      켓의 가치가 증가하면서 quality가 1 증가함, 콘서트 당일이 10일남았을떄, 5일남았을때를 기준으로 quality증가량이 1씩 늘어남. 날짜가 지나면서 콘      서트 날짜가 되면, 즉 sellin이 0이되면 콘서트가 끝나면서 티켓의 값어치가 0이되면서 quality가 0이됨
   - 아이템의 이름이 위의 3개중 어느것도 아니라면, 업데이트할때마다 시간이 지나면서 아이템의 값어치가 점점 떨어지면서 quality값이 감소함. 그러다        sellin이 0이하로 떨어지면 quality값의 감소량이 늘어남
