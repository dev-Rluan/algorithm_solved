import heapq


n= int(input());
cnt = 0;
sum = 0;
pi = list(map(int, input().split()))
heapq.heapify(pi)
c =0;
for i in range(0, n): 
    cnt = cnt + heapq.heappop(pi);
    sum +=cnt

print(sum)