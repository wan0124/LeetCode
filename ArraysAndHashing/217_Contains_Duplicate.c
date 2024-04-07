#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

bool containsDuplicate(int *, int);
void mergeSort(int *, int);
void sortForMergeSort(int *, int, int);
void mergeForMergeSort(int *, int, int, int);

void main()
{
    int numsSize = 5;
    int nums[] = {5, 5, 3, 2, 1};

    printf("result : %d", containsDuplicate(nums, numsSize));
}

bool containsDuplicate(int *nums, int numsSize)
{
    if (numsSize == 1)
    {
        return false;
    }

    // O(n^2)
    /*
    for (int i = 0; i < numsSize; i++)
    {
        for (int j = i; j < numsSize; j++)
        {
            if (nums[i] == nums[j])
            {
                return true;
            }
        }
    }

    return false;
    */

    // sort first
    mergeSort(nums, 5);
    // then compare
    for (int i = 0; i < numsSize - 1; i++)
    {
        if (nums[i] == nums[i + 1])
        {
            return true;
        }
    }

    return false;
}

void mergeSort(int *nums, int numsSize)
{
    sortForMergeSort(nums, 0, numsSize - 1);
}

void sortForMergeSort(int *nums, int left, int right)
{
    if (left == right)
    {
        return;
    }

    int index = (left + right) / 2;
    sortForMergeSort(nums, left, index);
    sortForMergeSort(nums, index + 1, right);

    mergeForMergeSort(nums, left, index, right);
}

void mergeForMergeSort(int *nums, int left, int index, int right)
{
    int leftArraySize = index - left + 1;
    int rightArraySize = right - index;

    int *leftArray = malloc(sizeof(int) * leftArraySize);
    int *rightArray = malloc(sizeof(int) * rightArraySize);

    // copy array
    for (int i = 0; i < leftArraySize; i++)
    {
        leftArray[i] = nums[left + i];
    }
    for (int i = 0; i < rightArraySize; i++)
    {
        rightArray[i] = nums[index + 1 + i];
    }

    int leftIndex = 0;
    int rightIndex = 0;
    int numsIndex = left;

    while (leftIndex < leftArraySize && rightIndex < rightArraySize)
    {
        if (leftArray[leftIndex] > rightArray[rightIndex])
        {
            nums[numsIndex++] = rightArray[rightIndex++];
        }
        else
        {
            nums[numsIndex++] = leftArray[leftIndex++];
        }
    }
    while (leftIndex < leftArraySize)
    {
        nums[numsIndex++] = leftArray[leftIndex++];
    }

    while (rightIndex < rightArraySize)
    {
        nums[numsIndex++] = leftArray[rightIndex++];
    }
}