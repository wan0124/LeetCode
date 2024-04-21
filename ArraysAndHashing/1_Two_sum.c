#include <stdlib.h>
#include <stdio.h>

// a struct with value and position
typedef struct Pair
{
    int value;
    int position;
} Pair;

int *twoSum(int *, int, int, int *);
int cmpfunc(const void *, const void *);
int main(void)
{
    int *returnSize = malloc(sizeof(int));
    int nums[] = {2, 7, 11, 15};
    int *result = twoSum(nums, 4, 9, returnSize);
    for (int i = 0; i < *returnSize; i++)
    {
        printf("%d, ", result[i]);
    }
}

int cmpfunc(const void *a, const void *b)
{
    return (((Pair *)a)->value - ((Pair *)b)->value);
}

int *twoSum(int *nums, int numsSize, int target, int *returnSize)
{
    // sort first. but may change the position, so use a struct?
    Pair *pairs = malloc(sizeof(Pair) * numsSize);
    for (int i = 0; i < numsSize; i++)
    {
        pairs[i].value = nums[i];
        pairs[i].position = i;
    }

    // then sort them
    qsort(pairs, numsSize, sizeof(Pair), cmpfunc);

    int rightIndex = 0;
    int leftIndex = numsSize - 1;

    *returnSize = 2;
    int *result = malloc(sizeof(int) * 2);

    while (rightIndex < leftIndex)
    {
        int sum = pairs[rightIndex].value + pairs[leftIndex].value;
        if (sum == target)
        {
            result[0] = pairs[rightIndex].position;
            result[1] = pairs[leftIndex].position;
            break;
        }
        else if (sum < target)
        {
            rightIndex++;
        }
        else
        {
            leftIndex--;
        }
    }

    return result;
}