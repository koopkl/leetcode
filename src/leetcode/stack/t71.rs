use std::ops::Add;

pub struct Solution {
    
}

impl Solution {
    pub fn simplify_path(path: String) -> String {
        let mut stack:Vec<String> = vec![];
        let res = path.split("/").for_each(|str| {
            if str.len() > 0 {
                match str {
                    "." => {},
                    ".." => {
                        if stack.len() > 0 {
                            stack.pop();
                        }
                    },
                    _ => {
                        stack.push(str.to_string());
                    }
                }
            }
        });
        "/".to_string() + stack.join("/").as_str()
    }
}