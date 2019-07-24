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
