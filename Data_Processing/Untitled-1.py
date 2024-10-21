'''
Author: Tianjun Chi harrychi@sjtu.edu.cn
Date: 2024-10-14 14:35:32
LastEditors: Tianjun Chi harrychi@sjtu.edu.cn
LastEditTime: 2024-10-14 15:01:31
FilePath: \IRS-PM-2024-09-10-GRP2-JobRecommendationSystem\Data_Processing\Untitled-1.py
Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
'''
ind = 0
input = [2,3,4,5,6,8,1,9]
k = 3

flg = k
for i in range(0,k):
    for flg in range(0,len(input)-1):
        if input[flg] < input[flg-1]:
            tmp = input[flg]
            input[flg]= input[flg-1]
            input[flg-1]= tmp

        if input[flg] > input[flg+1]:
            tmp = input[flg]
            input[flg]= input[flg+1]
            input[flg+1]= tmp

print(input[k])