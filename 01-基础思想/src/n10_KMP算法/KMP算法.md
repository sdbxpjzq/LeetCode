
在一个文本串S内查找一个模式串P 的出现位置

KMP方法算法就利用之前判断过信息，通过一个next数组，保存模式串中前后最长公共子序列的长度，  
每次回溯时，通过next数组找到，前面匹配过的位置，省去了大量的计算时间

参考:  
原作者: https://blog.csdn.net/v_july_v/article/details/7041827  
https://www.cnblogs.com/zzuuoo666/p/9028287.html
