pub struct Solution {

}

impl Solution {
    pub fn insert(intervals: Vec<Vec<i32>>, new_intervals: Vec<i32>) -> Vec<Vec<i32>>{
        let mut res: Vec<Vec<i32>> = vec![];
        let mut temp: Vec<i32> = vec![];

        for arr in intervals {
            // println!("temp: {:?}", temp);
            // println!("arr: {:?}", arr);
            // println!("new_intervals: {:?}", new_intervals);
            if temp.len() > 1 {
                res.push(arr.clone());
                continue
            }
            if arr[1] < new_intervals[0] {
                res.push(arr.clone());
                continue
            }
            if arr[1] >= new_intervals[0] && arr[0] <= new_intervals[0]{
                println!("{:?}", arr);
                temp.push(arr[0]);
                if arr[1] >= new_intervals[1] {
                    temp.push(arr[1]);
                    res.push(temp.clone());
                    continue
                } else {
                    continue
                }
            }
            if arr[0] > new_intervals[0] && arr[0] <= new_intervals[1]{
                if temp.len() == 0 {
                    temp.push(new_intervals[0]);
                    if new_intervals[1] <= arr[1] {
                        temp.push(arr[1]);
                        res.push(temp.clone());
                        continue
                    }
                }
            }
            if arr[0] > new_intervals[1] {
                if temp.len() == 0 {
                    temp.push(new_intervals[0]);
                    temp.push(new_intervals[1]);
                    res.push(temp.clone());
                } else if temp.len() == 1 {
                    temp.push(new_intervals[1]);
                    res.push(temp.clone());
                }
                res.push(arr.clone());
                continue
            }
            if arr[1] > new_intervals[1] && arr[0] <= new_intervals[1] {
                temp.push(arr[1]);
                res.push(temp.clone());
                continue
            }
        }
        if temp.len() == 0 {
            res.push(new_intervals);
        } else if temp.len() == 1 {
            temp.push(new_intervals[1]);
            res.push(temp);
        }
        res
    }
}